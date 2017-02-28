package ua.timan.invoice.service;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.collection.IsEmptyIterable.emptyIterable;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ua.timan.invoice.domain.Provider;
import ua.timan.invoice.domain.Storage;
import ua.timan.invoice.test.AbstractSpringTest;

public class StaticServiceTest extends AbstractSpringTest {

	public static final int EXISTEN_ID = 3;

	@Autowired
	private StaticService staticService;

	@Test
	public void shouldGetAllStorages() {
		List<Storage> list = staticService.getAllStorages();
		assertThat(list, not(emptyIterable()));
	}

	@Test
	public void shouldGetAllProviders() {
		List<Provider> list = staticService.getAllProviders();
		assertThat(list, not(emptyIterable()));
	}

	@Test
	public void shouldGetStorage() {
		Storage result = staticService.getStorage(EXISTEN_ID);
		assertNotNull(result);
	}

	@Test
	public void shouldGetProvider() {
		Provider result = staticService.getProvider(EXISTEN_ID);
		assertNotNull(result);
	}
	
	@Test
	public void shouldCheckExistingStorage(){
		staticService.existsStorage(EXISTEN_ID);
	}
	
	@Test
	public void shouldCheckExistingProvider(){
		staticService.existsProvider(EXISTEN_ID);
	}

}
