package py.com.poraplz.cursomc.module.client.infraestructure.db.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import py.com.poraplz.cursomc.dto.client.ClientDTO;
import py.com.poraplz.cursomc.module.client.domain.ClientType;
import py.com.poraplz.cursomc.module.direction.infraestructure.db.jpa.DirectionEntity;
import py.com.poraplz.cursomc.module.order.infraestructure.db.jpa.OrderEntity;
import py.com.poraplz.cursomc.module.profile.domain.Profile;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Table(name = "client")
@Data
public class ClientEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    private String cpfOuCnpj;
    private Integer type;
    @JsonIgnore
    private String password;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<DirectionEntity> addresses = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "phone")
    private Set<String> phone = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private List<OrderEntity> orders = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "PROFILE")
    private Set<Integer> profile = new HashSet<>();

    @JsonIgnore
    private String forgotPassToken;

    public ClientEntity() {
        addProfile(Profile.CLIENT);
    }

    public ClientEntity(ClientDTO dto) {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setName(dto.getName());
        clientEntity.setEmail(dto.getEmail());
        clientEntity.setAddresses(dto.getAdresses());
    }

    public ClientEntity(String name, String email, String cpfOuCnpj, ClientType tipo, String pass) {
        this.name = name;
        this.email = email;
        this.cpfOuCnpj = cpfOuCnpj;
        this.type = (tipo == null) ? null : tipo.getCod();
        this.password = pass;
    }

    public ClientType getType() {
        return ClientType.toEnum(this.type);
    }

    public void setType(ClientType tipo) {
        this.type = tipo.getCod();
    }


    public Set<Profile> getProfiles() {
        return profile.stream().map(value -> Profile.toEnum(value)).collect(Collectors.toSet());
    }

    public void addProfile(Profile profile) {
        this.profile.add(profile.getCod());
    }

    @Override
    public String toString() {
        return "ClientEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", cpfOuCnpj='" + cpfOuCnpj + '\'' +
                ", type=" + type +
                ", password='" + password + '\'' +
                ", adresses=" + addresses +
                ", phone=" + phone +
                ", orders=" + orders +
                ", profile=" + profile +
                ", forgotPassToken='" + forgotPassToken + '\'' +
                '}';
    }
}
