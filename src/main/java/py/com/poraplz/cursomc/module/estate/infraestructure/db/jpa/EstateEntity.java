package py.com.poraplz.cursomc.module.estate.infraestructure.db.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import py.com.poraplz.cursomc.module.city.infraestructure.db.jpa.CityEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "estate")
@Data
public class EstateEntity implements Serializable{
    private static final long serialVersionUID=1;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "state")
    private List<CityEntity> cities = new ArrayList<>();

    public EstateEntity(){

    }

    public EstateEntity(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "EstateEntity{" +
                "name='" + name + '\'' +
                ", cities=" + cities +
                '}';
    }
}
