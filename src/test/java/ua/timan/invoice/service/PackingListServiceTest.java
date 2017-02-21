package ua.timan.invoice.service;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.collection.IsEmptyIterable.emptyIterable;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static ua.timan.invoice.test.TestDataFactory.createPackingItem;
import static ua.timan.invoice.test.TestDataFactory.createPackingList;
import static ua.timan.invoice.test.TestDataFactory.createPackingLists;
import static ua.timan.invoice.test.TestDataFactory.createProducts;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ua.timan.invoice.domain.PackingItem;
import ua.timan.invoice.domain.PackingList;
import ua.timan.invoice.domain.Product;
import ua.timan.invoice.domain.ProductGroup;
import ua.timan.invoice.domain.Provider;
import ua.timan.invoice.domain.Storage;
import ua.timan.invoice.test.AbstractSpringTest;
import ua.timan.invoice.test.TestDataFactory;

public class PackingListServiceTest extends AbstractSpringTest {
	
	public static final int EXISTEN_ID = 4;
	public static final int DELETED_ID = 3;

	@Autowired
	private PackingListService pLService;

	@Test
	public void shouldCreatePackingLists() throws IOException {
		List<PackingList> register = createPackingLists();
		for (PackingList pList : register) {
			pLService.createPackingList(pList);
		}

	}
	
	
	@Test
	public void shouldCreatePackingList() throws IOException {
		PackingList entity = createPackingList();
		PackingList result = pLService.createPackingList(entity);

		entity.setId(result.getId());
		assertEquals(entity, result);
	}

	@Test
	public void shouldCreatePackingItem() throws IOException {
		PackingItem entity = createPackingItem();
		PackingItem result = pLService.createPackingItem(entity);

		entity.setId(result.getId());
		assertEquals(entity, result);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldNotCreatePackingListWithUnknownProvider() {
		PackingList pList = new PackingList();
		pList.setProvider(new Provider(20, "New provider"));
		pLService.createPackingList(pList);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldNotCreatePackingListWithUnknownStorage() {
		PackingList pList = new PackingList();
		pList.setStore(new Storage(20, "New storage"));
		pLService.createPackingList(pList);
	}
	
	@Test
	public void shouldGetAllPackingLists(){
		List<PackingList> list = pLService.getAllPackingLists();
		assertThat(list, not(emptyIterable()));
	}
	
	@Test
	public void shouldDeleteAndGetPackingList() {
		pLService.deletePackingList(DELETED_ID);
		assertNull(pLService.getPackingList(DELETED_ID));
	}
	
	@Test
	public void shouldDeleteAndGetProductItem() {
		pLService.deletePackingItem(DELETED_ID);
		assertNull(pLService.getPackingItem(DELETED_ID));
	}
	
}
