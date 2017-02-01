package ua.timan.invoice.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ua.timan.invoice.domain.ProductGroup;
import ua.timan.invoice.test.AbstractSpringTest;

public class ProductRepositoryTest extends AbstractSpringTest {

	public static final int IDGROUP = 1;
	public static final int IDPRODUCT = 1;

	private ProductGroup groupEntity;

	@Autowired
	private ProductGroupRepository groupRepository;

	@Before
	public void setUp() {
		groupEntity = new ProductGroup(IDGROUP, "Табачные изделия");
	}

	@Test
	public void shouldSaveAndGetProductGroupEntity() {
		groupRepository.save(groupEntity);
		ProductGroup result = groupRepository.findOne(IDGROUP);
		assertEquals(groupEntity, result);

	}

}
