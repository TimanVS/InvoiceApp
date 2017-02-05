package ua.timan.invoice.repository;

import static org.junit.Assert.assertEquals;
import static ua.timan.invoice.test.TestDataFactory.MAPPER;
import static ua.timan.invoice.test.TestDataFactory.getFixture;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;
import ua.timan.invoice.domain.Storage;
import ua.timan.invoice.test.AbstractSpringTest;

@Slf4j
public class StorageRepositoryTest extends AbstractSpringTest {

	public static final int ID = 1;

	private Storage entity;

	@Autowired
	private StorageRepository repository;

	@Before
	public void setUp() throws IOException {
		entity = (Storage) MAPPER.readValue(getFixture("Storage.json"), Storage.class);
	}

	@Test
	public void shouldSaveAndGetStorageEntity() {
		repository.save(entity);
		Storage result = repository.findOne(ID);
		assertEquals(entity, result);
		log.info(result.toString());

	}

}
