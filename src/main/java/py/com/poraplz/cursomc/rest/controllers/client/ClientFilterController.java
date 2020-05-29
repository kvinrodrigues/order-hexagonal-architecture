package py.com.poraplz.cursomc.rest.controllers.client;

import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import py.com.poraplz.cursomc.dto.client.ClientsDTO;
import py.com.poraplz.cursomc.module.client.infraestructure.db.jpa.ClientEntity;
import py.com.poraplz.cursomc.services.ClientService;

public class ClientFilterController {
    private ClientService service;

    public ClientFilterController(ClientService service) {
        this.service = service;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/client/filter", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<ClientsDTO>> filterClientPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                             @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
                                                             @RequestParam(value = "direction", defaultValue = "ASC") String direction,
                                                             @RequestParam(value = "orderBy", defaultValue = "name") String columnName){

        Page<ClientEntity> clients = service.filterCliente(page, linesPerPage, direction, columnName);
        Page<ClientsDTO> clientsDto = clients.map(ClientsDTO::new);
        return ResponseEntity.ok().body(clientsDto);

    }
}
