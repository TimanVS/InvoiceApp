package ua.timan.invoice.domain;

import static org.junit.Assert.assertNotNull;
import static ua.timan.invoice.test.TestDataFactory.MAPPER;
import static ua.timan.invoice.test.TestDataFactory.createPodam;
import static ua.timan.invoice.test.TestDataFactory.getFixture;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.extern.slf4j.Slf4j;
import ua.timan.invoice.test.AbstractSpringTest;

@Slf4j
public class PackingListJsonTest extends AbstractSpringTest{
	
	@Test
	public void shouldConvertPackingListToJson() throws JsonProcessingException {
		String json = MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(createPodam(PackingList.class));
		log.info(json);
	}
/*
	@Test
	public void shouldDeserializePackingList() throws IOException {
		PackingList result = (PackingList) MAPPER.readValue(getFixture("PackingList.json"), PackingList.class);
		log.info(result.toString());
		assertNotNull(result);
	}
	*/
	@Test
	public void shouldDeserializePackingItem() throws IOException {
		PackingItem result = (PackingItem) MAPPER.readValue(getFixture("PackingItem.json"), PackingItem.class);
		log.info(result.toString());
		assertNotNull(result);
	}

}