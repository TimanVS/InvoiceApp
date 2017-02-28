package ua.timan.invoice.repository;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.collection.IsEmptyIterable.emptyIterable;
import static org.junit.Assert.assertThat;
import static ua.timan.invoice.test.TestDataFactory.createProductGroup;

import org.junit.Assert;
import org.junit.Test;

import ua.timan.invoice.domain.ProductGroup;

public class ProductGroupRepositoryTest extends AbstractRepositoryTest<ProductGroup> {

	@Override
	protected ProductGroup createEntity() throws Exception {
		return createProductGroup();
	}

	@Test
	public void shouldFindProductGroupByName() {
		String existentName = "Кондитерские изделия";
		Iterable<ProductGroup> groups = ((ProductGroupRepository) repository).findByName(existentName);

		assertThat(groups, not(emptyIterable()));
		for (ProductGroup group : groups) {
			String result = group.getName();
			Assert.assertEquals(existentName, result);
		}

	}

}
