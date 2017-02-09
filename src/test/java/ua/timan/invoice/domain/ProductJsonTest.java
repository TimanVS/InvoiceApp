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
public class ProductJsonTest extends AbstractSpringTest {

	@Test
	public void shouldConvertProductToJson() throws JsonProcessingException {
		String json = MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(createPodam(Product.class));
		log.info(json);
	}

	@Test
	public void shouldDeserializeProduct() throws IOException {
		Product result = (Product) MAPPER.readValue(getFixture("Product.json"), Product.class);
		log.info(result.toString());
		assertNotNull(result);
	}

}
