package ua.timan.invoice.service;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.collection.IsEmptyIterable.emptyIterable;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static ua.timan.invoice.test.TestDataFactory.createProduct;
import static ua.timan.invoice.test.TestDataFactory.createProductGroup;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;
import ua.timan.invoice.domain.Product;
import ua.timan.invoice.domain.ProductGroup;
import ua.timan.invoice.repository.AbstractRepositoryTest;
import ua.timan.invoice.repository.ProductGroupRepository;
import ua.timan.invoice.repository.ProductRepository;
import ua.timan.invoice.test.AbstractSpringTest;

@Slf4j
public class ProductServiceTest extends AbstractSpringTest {

	private Product productEntity;
	private ProductGroup groupEntity;
	//private ProductService productService;

	@Autowired
	private ProductService productService;
	// Здесь он явно лишний, мы же тестируем сервис по принципу "черного ящика":
	// знаем что подаем на вход и что ожидаем на выходе. Как этот результат
	// достигается - мы не знаем.
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ProductGroupRepository groupRepository;

	@Before
	public void setUp() throws IOException {
		productEntity = createProduct();
	}
	
	@Before
	public void setUpGroupEntity() throws IOException {
		groupRepository.save(createProductGroup());
	}

	@Test
	public void shouldCreateAndGetProduct() {
		productService.createProduct(productEntity);
		Product result = productService.getProduct(productEntity.getId());
		assertEquals(productEntity, result);
		log.info(result.toString());

	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotCreateProductWithUnknownGroup() {
		Product product = new Product();
		product.setGroup(new ProductGroup(20, "Новая группа товаров"));
		productService.createProduct(product);
	}
/*
	@Test
	public void shouldUpdateProduct() {

	}
	*/
	@Test
	public void shouldFindAndGetProductsByBarcode(){
		//groupRepository.save(groupEntity);
		productRepository.save(productEntity);
		Iterable<Product> result = productRepository.findByBarcode(productEntity.getBarcode());
		assertThat(result, not(emptyIterable()));
		log.info(result.toString());
	}

}
