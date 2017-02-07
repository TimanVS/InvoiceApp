package ua.timan.invoice.repository;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.collection.IsEmptyIterable.emptyIterable;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static ua.timan.invoice.test.TestDataFactory.createProvider;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;
import ua.timan.invoice.domain.Provider;

@Slf4j
public class ProviderRepositoryTest extends AbstractRepositoryTest {

    public static final int ID = 1;

    private Provider entity;

    @Autowired
    private ProviderRepository repository;

    @Before
    public void setUpProvider() throws IOException {
        entity = createProvider();
    }

    @Test
    public void shouldSaveAndGetProviderEntity() {
        repository.save(entity);
        Provider result = repository.findOne(entity.getId());
        assertEquals(entity, result);
        log.info(result.toString());

        Iterable<Provider> providers = repository.findAll();
        assertThat(providers, not(emptyIterable()));

    }

}
