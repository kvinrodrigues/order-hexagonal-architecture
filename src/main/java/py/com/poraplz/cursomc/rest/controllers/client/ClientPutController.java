package py.com.poraplz.cursomc.rest.controllers.client;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import py.com.poraplz.cursomc.dto.client.ClientDTO;
import py.com.poraplz.cursomc.module.client.infraestructure.db.jpa.ClientEntity;
import py.com.poraplz.cursomc.services.ClientService;

import javax.validation.Valid;

@Controller
public class ClientPutController {
    private ClientService service;

    public ClientPutController(ClientService service) {
        this.service = service;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> update(@Valid @RequestBody ClientDTO request, @PathVariable Long id){
        ClientEntity clientEntity = service.updateClient(id, request);
        return ResponseEntity.noContent().build();

    }
}
