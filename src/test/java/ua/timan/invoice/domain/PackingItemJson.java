package ua.timan.invoice.domain;

import static org.junit.Assert.assertNotNull;
import static ua.timan.invoice.test.TestDataFactory.MAPPER;
import static ua.timan.invoice.test.TestDataFactory.createPodam;
import static ua.timan.invoice.test.TestDataFactory.getFixture;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PackingItemJson {

	@Test
	public void shouldConvertPackingItemToJson() throws JsonProcessingException {
		String json = MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(createPodam(PackingItem.class));
		log.info(json);
	}

	@Test
	public void shouldDeserializePackingItem() throws IOException {
		PackingItem result = MAPPER.readValue(getFixture("PackingItem.json"), PackingItem.class);
		log.info(result.toString());
		assertNotNull(result);
	}

}
