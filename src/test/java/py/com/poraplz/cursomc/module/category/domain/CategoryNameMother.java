package py.com.poraplz.cursomc.module.category.domain;

public final class CategoryNameMother {
    public static CategoryName create(String value) {
        return new CategoryName(value);
    }

    public static CategoryName random() {
        // TODO utilizar la libreria faker para obtener caracteres aleatorios
        return create("sdfasdfsafdadsfdsfsdafsdaf");
    }
}
