package py.com.poraplz.cursomc.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import py.com.poraplz.cursomc.dto.forgot.PasswordDto;
import py.com.poraplz.cursomc.module.client.infraestructure.db.jpa.ClientEntity;
import py.com.poraplz.cursomc.module.profile.domain.Profile;
import py.com.poraplz.cursomc.module.shared.domain.exceptions.ObjectNotFound;
import py.com.poraplz.cursomc.security.JWTUtil;

import java.util.Random;
import java.util.Set;

@Service
public class AuthService {
    private ClientService clienteService;
    private JWTUtil jwtUtil;
    private BCryptPasswordEncoder encoder;
    private EmailService emailService;
    private Random rand = new Random();

    public AuthService(ClientService clienteService, JWTUtil jwtUtil, BCryptPasswordEncoder encoder, EmailService emailService){
        this.clienteService = clienteService;
        this.jwtUtil = jwtUtil;
        this.encoder = encoder;
        this.emailService = emailService;
    }

    public String forgotPassword(String username){
        String token = jwtUtil.generateToken(username);
        ClientEntity clientEntity = clienteService.getByEmail(username);
        String forgotToken = null;

        Set<Profile> profiles = clientEntity.getProfiles();
        if(profiles.contains(Profile.FORGOT)){
            forgotToken = clientEntity.getForgotPassToken();
            if(forgotToken == null || !jwtUtil.isValidExpirationTime(forgotToken)){
                clientEntity.setForgotPassToken(token);
                forgotToken = token;
            }
        }else {
            clientEntity.setForgotPassToken(null);
        }
        clienteService.saveOrUpdate(clientEntity);
        emailService.sendChangeOfPassword(token);
        return forgotToken;

    }

    //Se pasa email obtenido desde el token y el nuevo password
    //implementar para recibir clave para confirmar cambio de password
    public Object changePasswordProcess(PasswordDto dto){
        String email = jwtUtil.getUserName(dto.getToken());
        ClientEntity clientEntity = clienteService.getByEmail(email);
        clientEntity.setPassword(encoder.encode(dto.getNewPassword()));
        clienteService.saveOrUpdate(clientEntity);
        return "se cambia pass";
    }


    public void sendNewPassword(String email){
        ClientEntity clientEntity = clienteService.getByEmail(email);
        if(clientEntity == null){
            throw new ObjectNotFound("Email no encontrado");
        }
        String newPass = newPassword();
        clientEntity.setPassword(encoder.encode(newPass));
        clienteService.saveOrUpdate(clientEntity);
        emailService.sendNewPasswordEmail(clientEntity, newPass);
    }

    private String newPassword(){
        char[] vet = new char[10];
        for (int i = 0; i < 10; i++){
            vet[i] = randomChar();
        }
        return new String(vet);
    }

    private char randomChar(){
        //Tres posibles valores
        int opt = rand.nextInt(3);
        //Digito
        if(opt == 0){
            return (char) (rand.nextInt(10) + 48);
        }else if(opt ==1){ //Letra mayuscula
            return (char) (rand.nextInt(26) + 65);
        }else{ //letra minuscula
            return (char) (rand.nextInt(26) + 97);
        }


    }
}
