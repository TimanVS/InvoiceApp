package ua.timan.invoice.repository;

import static ua.timan.invoice.test.TestDataFactory.createProductGroup;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Getter;
import ua.timan.invoice.domain.ProductGroup;

public class ProductGroupRepositoryTest extends AbstractRepositoryTest<ProductGroup, ProductGroupRepository> {

    @Getter
    @Autowired
    private ProductGroupRepository repository;

    @Override
    protected ProductGroup createEntity() throws Exception {
        return createProductGroup();
    }

}
