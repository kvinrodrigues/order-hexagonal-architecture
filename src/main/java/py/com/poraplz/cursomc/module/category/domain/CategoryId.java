package py.com.poraplz.cursomc.module.category.domain;

import java.util.Objects;

public final class CategoryId  {
    private final Long id;

    public CategoryId(Long id) {
        this.id = id;
    }

    public Long value() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryId that = (CategoryId) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
