package ua.timan.invoice.repository;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ua.timan.invoice.domain.PackingItem;
import ua.timan.invoice.domain.PackingList;
import ua.timan.invoice.domain.Provider;
import ua.timan.invoice.domain.Storage;
import ua.timan.invoice.domain.enums.Measure;
import ua.timan.invoice.test.AbstractSpringTest;

public class PackingListRepoTest extends AbstractSpringTest {
	
	public static final int IDPITEM = 1;
	public static final int IDPLIST = 1;
	public static final float PRICE = (float) 10.5;
	
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
	public void setUpPackingItem(){
		piEntity = new PackingItem(1, 1516, "Шоколад Корона 200г", Measure.PIECE, 1, PRICE, PRICE);
	}
	@Before
	public void setUpProvider() {
		providerEntity = new Provider(1, "ЛКО");
	}
	
	@Before
	public void setUp() {
		storageEntity = new Storage(1, "Мой магазин");
	}
	/*
	@Before
	public void setUpPackingList(){
		list = new ArrayList<PackingItem>();
		list.add(piEntity);
		plEntity = new PackingList(1, "2017-01-30", providerEntity, storageEntity, list, "Ну шо ишо?");
	}
	*/
	@Test
	public void shouldSaveAndGetPackingItemEntity() {
		piRepository.save(piEntity);
		PackingItem result = piRepository.findOne(IDPITEM);
		assertEquals(piEntity, result);
		}
	
	
	/*
	@Test
	public void shouldSaveAndGetPackingListEntity() {
		plRepository.save(plEntity);
		PackingList result = plRepository.findOne(IDPLIST);
		assertEquals(plEntity, result);
		}
		*/
}
