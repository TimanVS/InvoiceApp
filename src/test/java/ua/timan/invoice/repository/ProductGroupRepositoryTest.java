package ua.timan.invoice.repository;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.collection.IsEmptyIterable.emptyIterable;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static ua.timan.invoice.test.TestDataFactory.createProductGroup;

import org.junit.Test;

import ua.timan.invoice.domain.ProductGroup;

public class ProductGroupRepositoryTest extends AbstractRepositoryTest<ProductGroup> {

	public static final String EXISTENT_NAME = "Кондитерские изделия";

	@Override
	protected ProductGroup createEntity() throws Exception {
		return createProductGroup();
	}

	@Test
	public void shouldFindProductGroupByName() {
		Iterable<ProductGroup> groups = ((ProductGroupRepository) repository).findByName(EXISTENT_NAME);

		assertThat(groups, not(emptyIterable()));
		for (ProductGroup group : groups) {
			assertEquals(EXISTENT_NAME, group.getName());
		}
	}

}
