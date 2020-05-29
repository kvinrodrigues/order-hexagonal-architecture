package py.com.poraplz.cursomc.rest.controllers.client;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import py.com.poraplz.cursomc.dto.client.ClientsDTO;
import py.com.poraplz.cursomc.module.client.infraestructure.db.jpa.ClientEntity;
import py.com.poraplz.cursomc.services.ClientService;

import java.util.List;

@Controller
public class ClientGetController {
    private ClientService service;

    public ClientGetController(ClientService service) {
        this.service = service;
    }

    @RequestMapping(value = "client/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findClienteById(@PathVariable Long id){
        ClientEntity clientEntity = service.getClient(id);
        return ResponseEntity.ok().body(clientEntity);

    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "client/all", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClientsDTO>> all(){
        return ResponseEntity.ok().body(service.getAllClients());

    }
}
