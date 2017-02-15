package ua.timan.invoice.repository;

import static ua.timan.invoice.test.TestDataFactory.createProduct;

import ua.timan.invoice.domain.Product;

public class ProductRepositoryTest extends AbstractRepositoryTest<Product> {

    @Override
    protected Product createEntity() throws Exception {
        return createProduct();
    }

}
