package ua.timan.invoice.repository;

import static ua.timan.invoice.test.TestDataFactory.createProduct;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Getter;
import ua.timan.invoice.domain.Product;

public class ProductRepositoryTest extends AbstractRepositoryTest<Product, ProductRepository> {

    @Getter
    @Autowired
    private ProductRepository repository;

    @Override
    protected Product createEntity() throws Exception {
        return createProduct();
    }

}
