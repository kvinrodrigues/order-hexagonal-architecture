package py.com.poraplz.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import py.com.poraplz.cursomc.module.client.infraestructure.db.jpa.ClientEntity;
import py.com.poraplz.cursomc.security.JWTUtil;
import py.com.poraplz.cursomc.security.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ClientService clientService;

    @Autowired
    private JWTUtil jwtUtil;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        ClientEntity clientEntity = clientService.getByEmail(email);
        if(clientEntity == null){
            throw new UsernameNotFoundException(email);
        }
        return new User(jwtUtil, clientEntity.getId(), clientEntity.getEmail(), clientEntity.getPassword(), clientEntity.getProfiles(), clientEntity.getForgotPassToken());
    }
}
