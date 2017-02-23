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
public class StorageJsonTest {

	@Test
	public void shouldConvertStorageToJson() throws JsonProcessingException {
		String json = MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(createPodam(Storage.class));
		log.info(json);
	}

	@Test
	public void shouldDeserializeStorage() throws IOException {
		Storage result = (Storage) MAPPER.readValue(getFixture("Storage.json"), Storage.class);
		log.info(result.toString());
		assertNotNull(result);
	}
}
