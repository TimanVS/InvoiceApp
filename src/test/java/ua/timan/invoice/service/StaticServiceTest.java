package ua.timan.invoice.service;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.collection.IsEmptyIterable.emptyIterable;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ua.timan.invoice.domain.Storage;
import ua.timan.invoice.test.AbstractSpringTest;

public class StaticServiceTest extends AbstractSpringTest {

	@Autowired
	private StaticService staticService;

	@Test
	public void shouldGetAllStorages() {
		List<Storage> list = staticService.getAllStorages();
		assertThat(list, not(emptyIterable()));
	}

}
