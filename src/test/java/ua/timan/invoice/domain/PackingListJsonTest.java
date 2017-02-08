package ua.timan.invoice.domain;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import static ua.timan.invoice.test.TestDataFactory.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.extern.slf4j.Slf4j;
import ua.timan.web_static.ui.SampleWebStaticApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SampleWebStaticApplication.class)
@Slf4j
public class PackingListJsonTest {
	
	@Test
	public void shouldConvertPackingListToJson() throws JsonProcessingException {
		String json = MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(createPackingList());
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
	public void shouldDeserializeProduct() throws IOException {
		Product result = (Product) MAPPER.readValue(getFixture("Product.json"), Product.class);
		log.info(result.toString());
		assertNotNull(result);
	}

}