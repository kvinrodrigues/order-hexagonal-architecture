package py.com.poraplz.cursomc.services;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import py.com.poraplz.cursomc.dto.client.ClientDTO;
import py.com.poraplz.cursomc.dto.client.ClientNewDTO;
import py.com.poraplz.cursomc.dto.client.ClientsDTO;
import py.com.poraplz.cursomc.module.city.infrastructure.db.jpa.CityEntity;
import py.com.poraplz.cursomc.module.client.infraestructure.db.jpa.ClientEntity;
import py.com.poraplz.cursomc.module.direction.infraestructure.db.jpa.DirectionEntity;
import py.com.poraplz.cursomc.module.profile.domain.Profile;
import py.com.poraplz.cursomc.module.client.domain.ClientType;
import py.com.poraplz.cursomc.rest.controllers.auth.AuthorizationException;
import py.com.poraplz.cursomc.module.shared.domain.exceptions.BrokenDataIntegrity;
import py.com.poraplz.cursomc.module.shared.domain.exceptions.ObjectNotFound;
import py.com.poraplz.cursomc.module.city.domain.CityRepository;
import py.com.poraplz.cursomc.module.client.domain.ClientRepository;
import py.com.poraplz.cursomc.module.direction.domain.DirectionRepository;
import py.com.poraplz.cursomc.security.User;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ClientService {

    private ClientRepository repo;
    private DirectionRepository directionRepository;
    private CityRepository cityRepository;
    private BCryptPasswordEncoder encoder;

    public ClientService(ClientRepository clt, DirectionRepository directionRepository, CityRepository cityRepository,
                         BCryptPasswordEncoder encoder){
        this.repo = clt;
        this.directionRepository = directionRepository;
        this.cityRepository = cityRepository;
        this.encoder = encoder;

    }

    public ClientEntity getClient(Long id){
        User loggedUser = UserService.getLoggedUser();
        if(loggedUser == null || !loggedUser.hasRole(Profile.ADMIN) && !id.equals(loggedUser.getId())) {
            throw new AuthorizationException("Acceso Denegado");
        }

            Optional<ClientEntity> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFound("No se encontro cliente, id:" + id ));

    }

    public ClientEntity getByEmail(String email){
        Optional<ClientEntity> client = Optional.ofNullable(repo.getByEmail(email));
        return client.orElseThrow(() ->
                new ObjectNotFound("No se encontro cliente con email: "+ email));
    }

    public ClientEntity saveOrUpdate(ClientEntity clientEntity){
        clientEntity = repo.save(clientEntity);
        directionRepository.saveAll(clientEntity.getAddresses());
        return clientEntity;

    }

    public ClientEntity updateClient(Long id, ClientDTO request){
      return saveOrUpdate(setDataToUpdate(id, request));

    }

    @Transactional
    public ClientEntity saveClient(ClientNewDTO request){
        return saveOrUpdate(fromDtoToClient(request));

    }

    public Page<ClientEntity> filterCliente(Integer page, Integer linesPerPage, String direction, String column){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage,
                Sort.Direction.valueOf(direction), column);
        return repo.findAll(pageRequest);
    }

    public void deleteClient(Long id){
        getClient(id);
        try{
            repo.deleteById(id);

        }catch (DataIntegrityViolationException e){
            throw new BrokenDataIntegrity("Ya existen datos asociadas al cliente");
        }
    }

    public List<ClientsDTO> getAllClients(){
        List<ClientEntity> clientEntities = repo.findAll();
        return clientEntities.stream()
                .map(ClientsDTO::new)
                .collect(Collectors.toList());

    }

    public ClientEntity setDataToUpdate(Long id, ClientDTO dto){
        ClientEntity clientEntity = getClient(id);
        clientEntity.setName(dto.getName());
        clientEntity.setEmail(dto.getEmail());
        return clientEntity;

    }


    public ClientEntity fromDtoToClient(ClientNewDTO dto){
        ClientEntity clientEntity = new ClientEntity(dto.getName(), dto.getEmail(), dto.getCpfOuCnpj(), ClientType.toEnum(dto.getType()), encoder.encode(dto.getPass()));
        CityEntity cityEntity = cityRepository.findById(dto.getCityId()).orElseThrow(() ->
                new ObjectNotFound("No se encontro cityEntity, id: "+ dto.getCityId()));
        DirectionEntity dir = new DirectionEntity(dto.getStreet(), dto.getNumber(), dto.getComplement(), dto.getDistrict(), cityEntity, clientEntity);
        clientEntity.getAddresses().add(dir);
        clientEntity.getPhone().add(dto.getFirstPhone());
        if(dto.getSecondPhone() != null)
            clientEntity.getPhone().add(dto.getSecondPhone());
        if(dto.getThirdPhone() != null)
            clientEntity.getPhone().add(dto.getThirdPhone());
        return clientEntity;

    }


}
