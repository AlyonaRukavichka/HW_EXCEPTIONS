import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    Product item1 = new Product(22, "Книга", 235);
    Product item2 = new Product(5, "Альбом", 178);
    Product item3 = new Product(19, "Ножницы", 200);

    @Test
    public void shouldNotFindAndNotRemovedProduct() {
        ShopRepository repo = new ShopRepository();
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(6);
        });
    }

    @Test
    public void shouldRemoveById() {
        ShopRepository repo = new ShopRepository();
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);

        repo.removeById(5);

        Product[] expected = {item1, item3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }
}
