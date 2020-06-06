package py.com.poraplz.cursomc.module.category.domain;
// TODO utilizar libreria faker
public final class CategoryMother {
    public static Category create(CategoryId courseId, CategoryName categoryName) {
        return Category.from(courseId, categoryName);
    }

    public static Category random() {
        return create(CategoryIdMother.random(), CategoryNameMother.random());
    }
}
