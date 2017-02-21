package ua.timan.invoice.service;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.collection.IsEmptyIterable.emptyIterable;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static ua.timan.invoice.test.TestDataFactory.createProduct;
import static ua.timan.invoice.test.TestDataFactory.createProducts;
import static ua.timan.invoice.test.TestDataFactory.extractLastProduct;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ua.timan.invoice.domain.Product;
import ua.timan.invoice.domain.ProductGroup;
import ua.timan.invoice.test.AbstractSpringTest;
import ua.timan.invoice.test.TestDataFactory;


public class ProductServiceTest extends AbstractSpringTest {

	public static final int EXISTEN_PRODUCT_ID = 5;
	@Autowired
	private ProductService productService;

	@Test
	public void shouldCreateProductGroupAndProduct() throws IOException {
		List<Product> productList = createProducts();
		List<ProductGroup> productGroupList = TestDataFactory.createProductGroups();
		for (ProductGroup group : productGroupList) {
			productService.createProductGroup(group);
		}
		for (Product product : productList) {
			productService.createProduct(product);
		}

	}
	
	@Test
	public void shouldCreateProduct() throws IOException {
		Product product = createProduct();
		Product result = productService.createProduct(product);
		product.setId(result.getId());
		assertEquals(product, result);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotCreateProductWithExistentProduct() throws IOException {
		Product product = extractLastProduct();
		productService.createProduct(product);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotCreateProductWithUnknownGroup() {
		Product product = new Product();
		product.setGroup(new ProductGroup(20, "Новая группа товаров"));
		productService.createProduct(product);
	}

	@Test
	public void shouldGetAllProducts() {
		List<Product> list = productService.getAllProducts();
		assertThat(list, not(emptyIterable()));
	}

	@Test
	public void shouldGetAndUpdateProduct() throws IOException {
		Product product = productService.getProduct(EXISTEN_PRODUCT_ID);
		product.setName("Минтай с/м Аргентина");
		Product result = productService.updateProduct(product);

		assertEquals(product, result);
	}

}
