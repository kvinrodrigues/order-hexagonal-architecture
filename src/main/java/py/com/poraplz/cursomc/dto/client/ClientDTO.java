package py.com.poraplz.cursomc.dto.client;

import org.hibernate.validator.constraints.Length;
import py.com.poraplz.cursomc.module.client.infraestructure.db.jpa.ClientEntity;
import py.com.poraplz.cursomc.module.direction.infraestructure.db.jpa.DirectionEntity;
import py.com.poraplz.cursomc.services.validation.ClientUpdate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@ClientUpdate
public class ClientDTO {
    private Long id;
    @NotEmpty(message = "Campo obligatorio") @Length(min = 5, max = 120, message = "Longitud incorrecta")
    private String name;
    @NotEmpty(message = "Campo obligatorio") @Email
    private String email;
    @NotEmpty
    private List<DirectionEntity> adresses = new ArrayList<>();
    @NotEmpty
    private Set<Integer> profiles = new HashSet<>();



    public ClientDTO() {
    }

    public ClientDTO(ClientEntity clientEntity){
        this.name = clientEntity.getName();
        this.email = clientEntity.getEmail();

    }

    public ClientDTO(String name, String email, String cpfOuCnpj, Integer type, List<DirectionEntity> adresses, Set<String> phone) {
        this.name = name;
        this.email = email;

    }

    public List<DirectionEntity> getAdresses() {
        return adresses;
    }

    public void setAdresses(List<DirectionEntity> adresses) {
        this.adresses = adresses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Integer> getProfiles() {
        return profiles;
    }

    public void setProfiles(Set<Integer> profiles) {
        this.profiles = profiles;
    }
}
