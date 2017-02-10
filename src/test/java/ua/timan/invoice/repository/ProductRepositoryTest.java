package ua.timan.invoice.repository;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.collection.IsEmptyIterable.emptyIterable;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static ua.timan.invoice.test.TestDataFactory.createProduct;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ua.timan.invoice.domain.Product;

public class ProductRepositoryTest extends AbstractRepositoryTest {

	private Product productEntity;

	@Autowired
	private ProductRepository productRepository;

	@Before
	public void setUp() throws IOException {
		productEntity = createProduct();
	}

	@Test
	public void shouldSaveAndGetProductEntity() {
		productRepository.save(productEntity);
		Product result = productRepository.findOne(productEntity.getId());
		assertEquals(productEntity, result);

		Iterable<Product> products = productRepository.findAll();
		assertThat(products, not(emptyIterable()));
	}

}
