package ua.timan.invoice.service;

import static java.time.LocalDate.now;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.collection.IsEmptyIterable.emptyIterable;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static ua.timan.invoice.test.TestDataFactory.createPackingItem;
import static ua.timan.invoice.test.TestDataFactory.createPackingList;
import static ua.timan.invoice.test.TestDataFactory.createPackingLists;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;
import ua.timan.invoice.domain.PackingItem;
import ua.timan.invoice.domain.PackingList;
import ua.timan.invoice.domain.Product;
import ua.timan.invoice.domain.ProductGroup;
import ua.timan.invoice.domain.Provider;
import ua.timan.invoice.domain.Storage;
import ua.timan.invoice.domain.enums.Measure;
import ua.timan.invoice.test.AbstractSpringTest;

@Slf4j
public class PackingServiceTest extends AbstractSpringTest {

	public static final int EXISTENT_ID = 5;
	public static final int DELETED_ID = 6;

	@Autowired
	private PackingService service;

	@Test
	public void shouldCreatePackingLists() throws IOException {
		List<PackingList> register = createPackingLists();
		for (PackingList pList : register) {
			service.createPackingList(pList);
		}

	}

	@Test
	public void shouldCreatePackingList() throws IOException {
		PackingList entity = createPackingList();
		PackingList result = service.createPackingList(entity);

		entity.setId(result.getId());
		assertEquals(entity, result);
	}

	@Test
	public void shouldCreatePackingItem() throws IOException {
		PackingItem entity = createPackingItem();
		PackingItem result = service.createPackingItem(entity);

		entity.setId(result.getId());
		assertEquals(entity, result);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotCreatePackingListWithNullValue() {
		PackingList pList = null;
		service.createPackingList(pList);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotCreatePackingListWithUnknownProvider() {
		PackingList pList = new PackingList();
		pList.setProvider(new Provider(20, "New provider"));
		service.createPackingList(pList);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotCreatePackingListWithUnknownStorage() {
		PackingList pList = new PackingList();
		pList.setStore(new Storage(20, "New storage"));
		service.createPackingList(pList);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotCreatePackingItemWithUnknownProduct() {
		PackingItem item = new PackingItem();
		ProductGroup group = new ProductGroup();
		item.setProduct(new Product(20, "123456789", "New product", group, Measure.PIECE));
		service.createPackingItem(item);
	}

	@Test
	public void shouldGetAllPackingLists() {
		List<PackingList> list = service.getAllPackingLists();
		assertThat(list, not(emptyIterable()));
	}

	@Test
	public void shouldGetAllPackingItems() {
		List<PackingList> list = service.getAllPackingLists();
		assertThat(list, not(emptyIterable()));
	}

	@Test
	public void shouldDeleteAndGetPackingList() {
		service.deletePackingList(DELETED_ID);
		assertNull(service.getPackingList(DELETED_ID));
	}

	@Test
	public void shouldDeleteAndGetPackingItem() {
		service.deletePackingItem(DELETED_ID);
		assertNull(service.getPackingItem(DELETED_ID));
	}

	@Test
	@Transactional
	public void shouldGetAndUpdatePackingList() throws IOException {
		PackingList pList = service.getPackingList(EXISTENT_ID);
		pList.setProvider(new Provider(2, "Свиточ"));
		pList.setIssueDate(now());
		PackingList result = service.updatePackingList(pList);

		assertEquals(pList, result);
		log.info(result.toString());
	}

	@Test
	public void shouldGetAndUpdatePackingItem() throws IOException {
		PackingItem item = service.getPackingItem(EXISTENT_ID);
		item.setQuantity(BigDecimal.valueOf(8));
		item.setSum(BigDecimal.valueOf(204));
		PackingItem result = service.updatePackingItem(item);

		assertEquals(item, result);
		log.info(result.toString());
	}

	@Test
	public void shouldCheckExistingPackingList() {
		service.existsPackingList(EXISTENT_ID);
	}

	@Test
	public void shouldCheckExistingPackingItem() {
		service.existsPackingItem(EXISTENT_ID);
	}

}
