package ua.timan.invoice.repository;

import static org.junit.Assert.assertEquals;
import static ua.timan.invoice.test.TestDataFactory.MAPPER;
import static ua.timan.invoice.test.TestDataFactory.getFixture;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;
import ua.timan.invoice.domain.ProductGroup;
import ua.timan.invoice.test.AbstractSpringTest;

@Slf4j
public class ProductGroupRepositoryTest extends AbstractSpringTest {

	public static final int IDGROUP = 1;

	private ProductGroup groupEntity;

	@Autowired
	private ProductGroupRepository groupRepository;

	@Before
	public void setUp() throws IOException {
		groupEntity = (ProductGroup) MAPPER.readValue(getFixture("ProductGroup.json"), ProductGroup.class);
	}

	@Test
	public void shouldSaveAndGetProductGroupEntity() {
		groupRepository.save(groupEntity);
		ProductGroup result = groupRepository.findOne(IDGROUP);
		assertEquals(groupEntity, result);
		log.info(result.toString());
	}

}
