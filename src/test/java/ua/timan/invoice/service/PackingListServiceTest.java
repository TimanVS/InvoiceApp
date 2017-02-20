package ua.timan.invoice.service;

import static org.junit.Assert.assertEquals;
import static ua.timan.invoice.test.TestDataFactory.createPackingList;

import java.io.IOException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ua.timan.invoice.domain.PackingList;

public class PackingListServiceTest {
	
	@Autowired
	PackingListService pLService;
	
	@Test
	public void shouldCreatePackingList() throws IOException {
		PackingList pL = createPackingList();
		PackingList result = pLService.createPackingList(pL);
		assertEquals(pL, result);
		
	}

}
