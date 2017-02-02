package ua.timan.invoice.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ua.timan.invoice.domain.PackingItem;
import ua.timan.invoice.domain.Product;
import ua.timan.invoice.domain.ProductGroup;
import ua.timan.invoice.domain.enums.Measure;
import ua.timan.invoice.test.AbstractSpringTest;

public class ProductRepositoryTest extends AbstractSpringTest {

	public static final int IDGROUP = 1;
	public static final int IDPRODUCT = 1;
	
	public static final float PRICE = (float) 10.5;

	private ProductGroup groupEntity;
	private Product productEntity;
	private PackingItem piEntity;

	@Autowired
	private ProductGroupRepository groupRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private PackingItemRepository piRepository;

	@Before
	public void setUpProductGroup() {
		groupEntity = new ProductGroup(IDGROUP, "Табачные изделия");
	}
	
	@Before
	public void setUpProduct() {
		productEntity = new Product(IDPRODUCT, "Сигареты Парламент", groupEntity, Measure.PIECE);
	}
	
	@Before
	public void setUpPackingItem(){
		piEntity = new PackingItem(1, productEntity.getId(), productEntity.getName(), Measure.PIECE, 1, PRICE, PRICE);
	}

	@Test
	public void shouldSaveAndGetProductGroupEntity() {
		groupRepository.save(groupEntity);
		ProductGroup result = groupRepository.findOne(IDGROUP);
		assertEquals(groupEntity, result);
	}
	
	@Test
	public void shouldSaveAndGetProductEntity() {
		productRepository.save(productEntity);
		Product result = productRepository.findOne(IDPRODUCT);
		assertEquals(productEntity, result);
	}
	
	@Test
	public void shouldSaveAndGetPackingItemEntity() {
		piRepository.save(piEntity);
		PackingItem result = piRepository.findOne(1);
		assertEquals(piEntity, result);
	}

}
