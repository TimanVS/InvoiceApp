package ua.timan.invoice.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ua.timan.invoice.domain.Storage;
import ua.timan.invoice.test.AbstractSpringTest;

public class StorageRepositoryTest extends AbstractSpringTest {

    public static final int ID = 1;

    private Storage entity;

    @Autowired
    private StorageRepository repository;

    @Before
    public void setUp() {
        entity = new Storage(ID, "Мой магазин");
    }

    @Test
    public void shouldSaveAndGetStorageEntity() {
        repository.save(entity);
        Storage result = repository.findOne(ID);
        assertEquals(entity, result);
    }

}
