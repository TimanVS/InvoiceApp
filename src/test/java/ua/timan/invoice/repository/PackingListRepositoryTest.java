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
import ua.timan.invoice.domain.Provider;
import ua.timan.invoice.domain.Storage;

public class PackingListRepositoryTest extends AbstractRepositoryTest {

    public static final int IDPITEM = 1;
    public static final int IDPLIST = 1;
    public static final BigDecimal PRICE = BigDecimal.valueOf(5.23).setScale(2, RoundingMode.HALF_UP);

    
    private PackingList plEntity;
    private Provider providerEntity;
    private Storage storageEntity;
    private List<PackingItem> list;

   
    @Autowired
    private PackingListRepository plRepository;

   

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
    public void shouldSaveAndGetPackingListEntity() {
        plRepository.save(plEntity);
        PackingList result = plRepository.findOne(IDPLIST);
        assertEquals(plEntity, result);
    }
}
