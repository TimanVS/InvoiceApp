package ua.timan.invoice.repository;

import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.collection.IsEmptyIterable.emptyIterable;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static ua.timan.invoice.test.TestDataFactory.createProduct;

import org.junit.Test;

import ua.timan.invoice.domain.Product;

public class ProductRepositoryTest extends AbstractRepositoryTest<Product> {

	@Override
	protected Product createEntity() throws Exception {
		return createProduct();
	}

	@Test
	public void shouldFindProductByBarcode() {
		int existenId = 1;
		Product existenProduct = repository.findOne(existenId);
		assertNotNull("Get null Product for id " + existenId, existenProduct);
		Iterable<Product> result = ((ProductRepository) repository).findByBarcode(existenProduct.getBarcode());

		assertThat(result, not(emptyIterable()));
		assertThat(result, hasItems(existenProduct));
	}

	@Test
	public void shouldFindProductByGroup() {
		int existenId = 3;
		Product existenProduct = repository.findOne(existenId);
		assertNotNull("Get null Product for id " + existenId, existenProduct);
		Iterable<Product> result = ((ProductRepository) repository).findByGroup(existenProduct.getGroup());

		assertThat(result, not(emptyIterable()));
		assertThat(result, hasItems(existenProduct));
	}

}
