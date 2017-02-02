package ua.timan.invoice.repository;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ua.timan.invoice.domain.PackingItem;
import ua.timan.invoice.domain.PackingList;
import ua.timan.invoice.domain.Product;
import ua.timan.invoice.domain.Provider;
import ua.timan.invoice.domain.Storage;
import ua.timan.invoice.domain.enums.Measure;
import ua.timan.invoice.test.AbstractSpringTest;

public class PackingListRepositoryTest extends AbstractSpringTest {

    public static final int IDPITEM = 1;
    public static final int IDPLIST = 1;
    public static final BigDecimal PRICE = BigDecimal.valueOf(5.23).setScale(2, RoundingMode.HALF_UP);

    private PackingItem piEntity;
    private PackingList plEntity;
    private Provider providerEntity;
    private Storage storageEntity;
    private List<PackingItem> list;

    @Autowired
    private PackingItemRepository piRepository;
    @Autowired
    private PackingListRepository plRepository;

    @Before
    public void setUpPackingItem() {
        providerEntity = new Provider(1, "ЛКО");
        storageEntity = new Storage(1, "Мой магазин");
    }

    @Before
    public void setUpProvider() {

    }

    @Before
    public void setUp() {

    }

    /*
     * @Before public void setUpPackingList(){ list = new
     * ArrayList<PackingItem>(); list.add(piEntity); plEntity = new
     * PackingList(1, "2017-01-30", providerEntity, storageEntity, list,
     * "Ну шо ишо?"); }
     */
    @Test
    public void shouldSaveAndGetPackingItemEntity() {
        piRepository.save(piEntity);
        PackingItem result = piRepository.findOne(IDPITEM);
        assertEquals(piEntity, result);
    }

    /*
     * @Test public void shouldSaveAndGetPackingListEntity() {
     * plRepository.save(plEntity); PackingList result =
     * plRepository.findOne(IDPLIST); assertEquals(plEntity, result); }
     */
}
