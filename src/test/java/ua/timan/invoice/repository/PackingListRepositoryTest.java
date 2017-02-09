package ua.timan.invoice.repository;

import static org.junit.Assert.assertEquals;
import static ua.timan.invoice.test.TestDataFactory.createPackingList;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ua.timan.invoice.domain.PackingList;

public class PackingListRepositoryTest extends AbstractRepositoryTest {

	private PackingList plEntity;

	@Autowired
	private PackingListRepository plRepository;

	@Before
	public void setUpPackingList() throws IOException {
		plEntity = createPackingList();
	}

	@Test
	public void shouldSaveAndGetPackingListEntity() {
		plRepository.save(plEntity);
		PackingList result = plRepository.findOne(plEntity.getId());
		assertEquals(plEntity, result);
	}
}
