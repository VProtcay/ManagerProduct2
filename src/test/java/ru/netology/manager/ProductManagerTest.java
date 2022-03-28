package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.SmartPhone;
import ru.netology.repo.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private final Product firstProduct = new Product(1, "firstProduct_me", 1);
    private final Product secondProduct = new Product(2, "secondProduct", 2);
    private final Book firstBook = new Book(3, "firstBook", 3, "me");
    private final Book secondBook = new Book(4, "secondBook", 4, "you");
    private final SmartPhone firstSmartPhone = new SmartPhone(5, "firstSmartPhone", 5, "me");
    private final SmartPhone secondSmartPhone = new SmartPhone(6, "secondSmartPhone", 6, "you");
    private final ProductManager manager = new ProductManager(new ProductRepository());

    @BeforeEach
    void setUp() {
        manager.save(firstProduct);
        manager.save(secondProduct);
        manager.save(firstBook);
        manager.save(secondBook);
        manager.save(firstSmartPhone);
        manager.save(secondSmartPhone);

    }

    @Test
    void shouldReturnByText() {
        Product[] expected = {firstProduct, firstBook, firstSmartPhone};
        Product[] actual = manager.searchBy("me");
        assertArrayEquals(expected, actual);
        for (Product product : actual) {
            System.out.println(product);
        }
    }

    @Test
    void shouldReturnEmptyArrayByText() {
        Product[] actual = manager.searchBy("me123");
        assertEquals(0, actual.length);
    }
}