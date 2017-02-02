package ua.timan.invoice.repository;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;

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

    public static final BigDecimal PRICE = BigDecimal.valueOf(10.5).setScale(2, RoundingMode.HALF_UP);

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
    public void setUp() {
        groupEntity = new ProductGroup(IDGROUP, "Табачные изделия");
        productEntity = new Product(IDPRODUCT, "Сигареты Парламент", groupEntity, Measure.PIECE);
        piEntity = new PackingItem(1, "", productEntity, BigDecimal.ONE, PRICE, PRICE);
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
