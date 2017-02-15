package ua.timan.invoice.repository;

import static ua.timan.invoice.test.TestDataFactory.createPackingItem;

import ua.timan.invoice.domain.PackingItem;

public class PackingItemRepositoryTest extends AbstractRepositoryTest<PackingItem> {

    @Override
    protected PackingItem createEntity() throws Exception {
        return createPackingItem();
    }

}
