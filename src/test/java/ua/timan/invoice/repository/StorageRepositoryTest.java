package ua.timan.invoice.repository;

import static ua.timan.invoice.test.TestDataFactory.createStorage;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Getter;
import ua.timan.invoice.domain.Storage;

public class StorageRepositoryTest extends AbstractRepositoryTest<Storage, StorageRepository> {

    @Getter
    @Autowired
    private StorageRepository repository;

    @Override
    protected Storage createEntity() throws Exception {
        return createStorage();
    }

}
