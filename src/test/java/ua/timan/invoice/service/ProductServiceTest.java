package ua.timan.invoice.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ua.timan.invoice.domain.Product;
import ua.timan.invoice.domain.ProductGroup;
import ua.timan.invoice.test.AbstractSpringTest;

public class ProductServiceTest extends AbstractSpringTest {

    @Autowired
    private ProductService productService;

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotCreateProductWithUnknownGroup() {
        Product product = new Product();
        product.setGroup(new ProductGroup(20, "Новая группа товаров"));
        productService.create(product);
    }
}
