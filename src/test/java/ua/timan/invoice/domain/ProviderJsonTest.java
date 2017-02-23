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
public class ProviderJsonTest {

	@Test
	public void shouldConvertProviderToJson() throws JsonProcessingException {
		String json = MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(createPodam(Provider.class));
		log.info(json);
	}

	@Test
	public void shouldDeserializeProvider() throws IOException {
		Provider result = (Provider) MAPPER.readValue(getFixture("Provider.json"), Provider.class);
		log.info(result.toString());
		assertNotNull(result);
	}
}
