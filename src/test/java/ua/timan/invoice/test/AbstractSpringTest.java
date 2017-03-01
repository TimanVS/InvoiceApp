package ua.timan.invoice.test;

import static ua.timan.invoice.test.TestDataFactory.getFixture;
import static ua.timan.invoice.test.TestDataFactory.getRandomItem;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.SimpleType;

import ua.timan.invoice.domain.Storage;
import ua.timan.web_static.ui.SampleWebStaticApplication;

@ContextConfiguration(classes = SampleWebStaticApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public abstract class AbstractSpringTest<E> {
	
	public static final ObjectMapper MAPPER = new ObjectMapper();
    public static final String JSON_EXT = "s.json";
	
	@SuppressWarnings("unchecked")
	private Class<E> entityClass = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	
	public List<E> createEntities() throws IOException {
		return MAPPER.readValue(createJson(),
				CollectionType.construct(List.class, SimpleType.construct(entityClass)));
	}
	
	public E createStorage() throws IOException {
		return getRandomItem(createEntities());
	}
	
	private String createJson() {
		try {
			return getFixture(entityClass.getSimpleName() + JSON_EXT);
		} catch (IOException e) {
			Assert.fail("Can't create fixture!");
			return null;
		}
	}
}
