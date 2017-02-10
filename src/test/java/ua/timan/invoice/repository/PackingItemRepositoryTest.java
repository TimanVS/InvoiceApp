package ua.timan.invoice.repository;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.collection.IsEmptyIterable.emptyIterable;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static ua.timan.invoice.test.TestDataFactory.createPackingItem;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ua.timan.invoice.domain.PackingItem;

public class PackingItemRepositoryTest extends AbstractRepositoryTest {

	private PackingItem piEntity;

	@Autowired
	private PackingItemRepository piRepository;

	@Before
	public void setUpPackingItem() throws IOException {
		piEntity = createPackingItem();
	}

	@Test
	public void shouldSaveAndGetPackingItemEntity() {
		piRepository.save(piEntity);
		PackingItem result = piRepository.findOne(piEntity.getId());
		assertEquals(piEntity, result);

		Iterable<PackingItem> items = piRepository.findAll();
		assertThat(items, not(emptyIterable()));
	}

}
