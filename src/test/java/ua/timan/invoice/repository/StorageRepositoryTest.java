package ua.timan.invoice.repository;

import static ua.timan.invoice.test.TestDataFactory.createStorage;

import ua.timan.invoice.domain.Storage;

public class StorageRepositoryTest extends AbstractRepositoryTest<Storage> {

    @Override
    protected Storage createEntity() throws Exception {
        return createStorage();
    }

}
