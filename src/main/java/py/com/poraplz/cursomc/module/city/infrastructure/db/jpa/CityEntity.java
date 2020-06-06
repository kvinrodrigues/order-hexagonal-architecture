package py.com.poraplz.cursomc.module.city.infrastructure.db.jpa;


import lombok.Data;
import py.com.poraplz.cursomc.module.direction.infraestructure.db.jpa.DirectionEntity;
import py.com.poraplz.cursomc.module.estate.infraestructure.db.jpa.EstateEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "city")
@Data
public class CityEntity implements Serializable{
    private static final long serialVersionUID=1;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


    @ManyToOne
    @JoinColumn(name= "state_id")
    private EstateEntity state;

    @OneToMany(mappedBy = "city")
    private List<DirectionEntity> addresses = new ArrayList<>();

    public CityEntity() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityEntity cityEntity = (CityEntity) o;
        return Objects.equals(id, cityEntity.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "CityEntity{" +
                "name='" + name + '\'' +
                ", state=" + state +
                '}';
    }
}
