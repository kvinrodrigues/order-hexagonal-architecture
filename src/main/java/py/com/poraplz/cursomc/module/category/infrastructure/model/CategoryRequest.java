package py.com.poraplz.cursomc.module.category.infrastructure.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public final class CategoryRequest {
    @NotEmpty(message = "0031") @Size(min = 5, max = 80, message = "0032")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
