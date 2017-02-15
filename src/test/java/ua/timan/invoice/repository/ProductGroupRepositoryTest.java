package ua.timan.invoice.repository;

import static ua.timan.invoice.test.TestDataFactory.createProductGroup;

import ua.timan.invoice.domain.ProductGroup;

public class ProductGroupRepositoryTest extends AbstractRepositoryTest<ProductGroup> {

    @Override
    protected ProductGroup createEntity() throws Exception {
        return createProductGroup();
    }

}
