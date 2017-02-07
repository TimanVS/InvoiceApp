package ua.timan.invoice.repository;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.collection.IsEmptyIterable.emptyIterable;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static ua.timan.invoice.test.TestDataFactory.createStorage;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;
import ua.timan.invoice.domain.Storage;
import ua.timan.invoice.test.AbstractSpringTest;

@Slf4j
public class StorageRepositoryTest extends AbstractSpringTest {

    private Storage entity;

    @Autowired
    private StorageRepository repository;

    @Before
    public void setUp() throws IOException {
        entity = createStorage();
    }

    @Test
    public void shouldSaveAndGetStorageEntity() {
        repository.save(entity);
        Storage result = repository.findOne(entity.getId());
        assertEquals(entity, result);
        log.info(result.toString());

        Iterable<Storage> storages = repository.findAll();
        assertThat(storages, not(emptyIterable()));
    }

}
