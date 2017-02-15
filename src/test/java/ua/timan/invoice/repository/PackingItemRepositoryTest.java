package ua.timan.invoice.repository;

import static ua.timan.invoice.test.TestDataFactory.createPackingItem;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Getter;
import ua.timan.invoice.domain.PackingItem;

public class PackingItemRepositoryTest extends AbstractRepositoryTest<PackingItem, PackingItemRepository> {

    @Autowired
    @Getter
    private PackingItemRepository repository;

    @Override
    protected PackingItem createEntity() throws Exception {
        return createPackingItem();
    }

}
