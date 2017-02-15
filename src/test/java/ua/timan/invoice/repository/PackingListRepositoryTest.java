package ua.timan.invoice.repository;

import static ua.timan.invoice.test.TestDataFactory.createPackingList;

import ua.timan.invoice.domain.PackingList;

public class PackingListRepositoryTest extends AbstractRepositoryTest<PackingList> {

    @Override
    protected PackingList createEntity() throws Exception {
        return createPackingList();
    }
}
