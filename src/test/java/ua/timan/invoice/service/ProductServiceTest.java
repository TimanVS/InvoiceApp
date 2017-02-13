package ua.timan.invoice.service;

import static org.junit.Assert.assertEquals;
import static ua.timan.invoice.test.TestDataFactory.createProduct;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;
import ua.timan.invoice.domain.Product;
import ua.timan.invoice.domain.ProductGroup;
import ua.timan.invoice.repository.ProductRepository;
import ua.timan.invoice.test.AbstractSpringTest;

@Slf4j
public class ProductServiceTest extends AbstractSpringTest {

	private Product productEntity;

	@Autowired
	private ProductService productService;
	// Здесь он явно лишний, мы же тестируем сервис по принципу "черного ящика":
	// знаем что подаем на вход и что ожидаем на выходе. Как этот результат
	// достигается - мы не знаем.
	@Autowired
	private ProductRepository productRepository;

	@Before
	public void setUp() throws IOException {
		productEntity = createProduct();
	}

	@Test
	public void shouldCreateAndGetProduct() {
		// id должен прописываться внутри create метода, а не приходить из вне
		productEntity.setId((int) (productRepository.count() + 1));
		productService.create(productEntity);
		Product result = productService.get(productEntity.getId());
		assertEquals(productEntity, result);
		log.info(result.toString());

	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotCreateProductWithUnknownGroup() {
		Product product = new Product();
		product.setGroup(new ProductGroup(20, "Новая группа товаров"));
		productService.create(product);
	}

	@Test
	public void shouldUpdateProduct() {

	}

}
