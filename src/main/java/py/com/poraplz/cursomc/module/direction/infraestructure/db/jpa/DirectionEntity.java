package py.com.poraplz.cursomc.module.direction.infraestructure.db.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import py.com.poraplz.cursomc.module.city.infraestructure.db.jpa.CityEntity;
import py.com.poraplz.cursomc.module.client.infraestructure.db.jpa.ClientEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "direction")
@Data
public class DirectionEntity implements Serializable {
    private static final long serialVersionUID= 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //Barrio
    private String street;
    private Integer number;
    private String complement;
    //Barrio
    private String district;
    private String cep;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="client_id")
    private ClientEntity client;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private CityEntity city;

    public DirectionEntity() {
    }

    public DirectionEntity(String street, Integer number, String complement, String district, CityEntity city, ClientEntity client) {
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.district = district;
        this.city = city;
        this.client = client;
    }


    @Override
    public String toString() {
        return "DirectionEntity{" +
                "street='" + street + '\'' +
                ", number=" + number +
                ", complement='" + complement + '\'' +
                ", district='" + district + '\'' +
                ", cep='" + cep + '\'' +
                ", clientEntity=" + client +
                ", cityEntity=" + city +
                '}';
    }
}
