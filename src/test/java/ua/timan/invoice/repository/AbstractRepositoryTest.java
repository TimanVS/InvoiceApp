package ua.timan.invoice.repository;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.collection.IsEmptyIterable.emptyIterable;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static ua.timan.invoice.test.TestDataFactory.getResourceAsString;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import lombok.extern.slf4j.Slf4j;
import ua.timan.invoice.domain.IdAware;
import ua.timan.invoice.test.AbstractSpringTest;

@Slf4j
public abstract class AbstractRepositoryTest<E extends IdAware> extends AbstractSpringTest implements InitializingBean {

    private static boolean testDataInserted = false;

    @Autowired
    protected DataSource dataSource;

    @Autowired
    protected CrudRepository<E, Integer> repository;

    protected E entity;

    @Override
    public final void afterPropertiesSet() throws SQLException, IOException {
        if (testDataInserted) {
            return;
        }
        try (Connection connection = dataSource.getConnection(); Statement statement = connection.createStatement()) {
            statement.execute(getResourceAsString("test-data.sql"));
        }
        testDataInserted = true;
    }

    @Before
    public final void setUp() throws Exception {
        entity = createEntity();
    }

    protected int getExistenId() {
        return new Random().nextInt((int) repository.count()) + 1;
    }

    @Test
    @Transactional
    public final void shouldSaveAndGetEntity() {
        E result = repository.save(entity);

        log.info("{} was saved with id {}", entity.getClass().getSimpleName(), result.getId());
        entity.setId(result.getId());

        result = repository.findOne(entity.getId());
        assertEquals(entity, result);

        Iterable<E> items = repository.findAll();

        assertThat(items, not(emptyIterable()));
        log.info(items.toString());
    }

    protected abstract E createEntity() throws Exception;
}
