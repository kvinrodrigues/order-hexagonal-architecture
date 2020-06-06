package py.com.poraplz.cursomc.module.category.domain;

import java.util.Random;

public final class CategoryIdMother {
    public static CategoryId create(Long value) {
        return new CategoryId(value);
    }

    public static CategoryId random() {
        Long randomNumber = new Random().nextLong();
        return new CategoryId(randomNumber);
    }
}
