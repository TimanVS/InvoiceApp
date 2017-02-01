package ua.timan.invoice.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ua.timan.invoice.domain.Provider;
import ua.timan.invoice.test.AbstractSpringTest;

public class ProviderRepositoryTest extends AbstractSpringTest {
	
	public static final int ID = 1;

	private Provider entity;

	@Autowired
	private ProviderRepository repository;

	@Before
	public void setUp() {
		entity = new Provider(ID, "ЛКО");
	}

	@Test
	public void shouldSaveAndGetProviderEntity() {
		repository.save(entity);
		Provider result = repository.findOne(ID);
		assertEquals(entity, result);

	}

}
