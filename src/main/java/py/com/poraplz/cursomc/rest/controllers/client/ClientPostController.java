package py.com.poraplz.cursomc.rest.controllers.client;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import py.com.poraplz.cursomc.dto.client.ClientNewDTO;
import py.com.poraplz.cursomc.module.client.infraestructure.db.jpa.ClientEntity;
import py.com.poraplz.cursomc.services.ClientService;

import javax.validation.Valid;
import java.net.URI;

@Controller
public class ClientPostController {
//    private ClientService service;
//
//    public ClientPostController(ClientService service) {
//        this.service = service;
//    }
//
//    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Void> save(@Valid @RequestBody ClientNewDTO request){
//        ClientEntity clientEntity = service.saveClient(request);
//        URI uri = ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(clientEntity.getId())
//                .toUri();
//        return ResponseEntity.created(uri).build();
//    }
}
