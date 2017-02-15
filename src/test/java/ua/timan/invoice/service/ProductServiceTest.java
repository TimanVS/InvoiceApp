package ua.timan.invoice.service;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.collection.IsEmptyIterable.emptyIterable;
import static org.junit.Assert.assertThat;
import static ua.timan.invoice.test.TestDataFactory.createProducts;
import static ua.timan.invoice.test.TestDataFactory.extractLastProduct;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;
import ua.timan.invoice.domain.Product;
import ua.timan.invoice.domain.ProductGroup;
import ua.timan.invoice.test.AbstractSpringTest;
import ua.timan.invoice.test.TestDataFactory;

@Slf4j
public class ProductServiceTest extends AbstractSpringTest {

	@Autowired
	private ProductService productService;

	@Before
	public void souldCreateProductGroupAndProduct() throws IOException {
		List<Product> productList = createProducts();
		List<ProductGroup> productGroupList = TestDataFactory.createProductGroups();
		for (ProductGroup group : productGroupList) {
			productService.createProductGroup(group);
		}
		for (Product product : productList) {
			productService.createProduct(product);
		}

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
	public void shouldUpdateProduct() throws IOException {
		Product product = extractLastProduct();
		product.setName("Минтай с/м Аргентина");
		productService.updateProduct(product);
		
		
		
	}

}
