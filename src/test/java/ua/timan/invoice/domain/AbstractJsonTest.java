package ua.timan.invoice.domain;

import static org.junit.Assert.assertNotNull;
import static ua.timan.invoice.test.TestDataFactory.MAPPER;
import static ua.timan.invoice.test.TestDataFactory.createPodam;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.extern.slf4j.Slf4j;
import ua.timan.invoice.test.TestDataFactory;

@Slf4j
public abstract class AbstractJsonTest<T> {

	public static final String JSON_EXT = ".json";

	private T entity;

	private Class<T> entityClass;

	@Before
	@SuppressWarnings("unchecked")
	public final void setUp() {
		entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		entity = createPodam(entityClass);
	}

	@Test
	public final void shouldConvertEntityToJson() throws JsonProcessingException {
		String json = MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(entity);
		log.info(json);
	}

	@Test
	public final void shouldDeserializeEntityFromJson() throws IOException {
		T result = MAPPER.readValue(createJson(), entityClass);
		log.info(result.toString());
		assertNotNull(result);
	}

	private String createJson() {
		try {
			return TestDataFactory.getFixture(entityClass.getSimpleName() + JSON_EXT);
		} catch (IOException e) {
			Assert.fail("Can't create fixture!");
			return null;
		}
	}

}