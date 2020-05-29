package py.com.poraplz.cursomc.rest.controllers.client;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import py.com.poraplz.cursomc.services.ClientService;

public final class ClientDeleteController {
    private ClientService service;

    public ClientDeleteController(ClientService service) {
        this.service = service;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "client/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.deleteClient(id);
        return ResponseEntity.noContent().build();

    }
}
