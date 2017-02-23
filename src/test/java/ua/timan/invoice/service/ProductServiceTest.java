package ua.timan.invoice.service;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.collection.IsEmptyIterable.emptyIterable;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
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
	public static final int DELETED_PRODUCT_ID = 6;
	public static final int UNDELETABLE_PRODUCTGROUP_ID = 3;
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

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotCreateProductWithNullValue() throws IOException {
		Product product = null;
		productService.createProduct(product);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotCreateProductGroupWithNullValue() throws IOException {
		ProductGroup group = null;
		productService.createProductGroup(group);
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

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotCreateProductWithNullGroup() {
		Product product = new Product();
		product.setGroup(null);
		productService.createProduct(product);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotCreateProductWithNullBarcode() {
		Product product = new Product();
		product.setGroup(new ProductGroup(3, "Табачные изделия"));
		product.setBarcode(null);
		productService.createProduct(product);
	}

	@Test
	public void shouldGetAllProducts() {
		List<Product> list = productService.getAllProducts();
		assertThat(list, not(emptyIterable()));
	}

	@Test
	public void shouldGetAllProductGroups() {
		List<ProductGroup> list = productService.getAllProductGroups();
		assertThat(list, not(emptyIterable()));
	}

	@Test
	public void shouldGetAndUpdateProduct() throws IOException {
		Product product = productService.getProduct(EXISTEN_PRODUCT_ID);
		product.setName("Минтай с/м Аргентина");
		Product result = productService.updateProduct(product);

		assertEquals(product, result);
	}

	@Test
	public void shouldGetAndUpdateProductGroup() throws IOException {
		ProductGroup group = productService.getProductGroup(EXISTEN_PRODUCT_ID);
		group.setName("Химия");
		ProductGroup result = productService.updateProductGroup(group);

		assertEquals(group, result);
	}

	@Test
	public void shouldDeleteAndGetProduct() {
		productService.deleteProduct(DELETED_PRODUCT_ID);
		assertNull(productService.getProduct(DELETED_PRODUCT_ID));
	}

	@Test
	public void shouldDeleteAndGetProductGroup() {
		productService.deleteProductGroup(DELETED_PRODUCT_ID);
		assertNull(productService.getProductGroup(DELETED_PRODUCT_ID));
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotDeleteProductGroupIfProductContainsIt() {
		productService.deleteProductGroup(UNDELETABLE_PRODUCTGROUP_ID);
	}

}
