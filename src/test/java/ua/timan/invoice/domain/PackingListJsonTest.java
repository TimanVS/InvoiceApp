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
public class PackingListJsonTest {

	@Test
	public void shouldConvertPackingListToJson() throws JsonProcessingException {
		String json = MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(createPodam(PackingList.class));
		log.info(json);
	}

	@Test
	public void shouldDeserializePackingList() throws IOException {
		PackingList result = (PackingList) MAPPER.readValue(getFixture("PackingList.json"), PackingList.class);
		log.info(result.toString());
		assertNotNull(result);
	}
}