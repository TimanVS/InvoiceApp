package ua.timan.invoice.test;

import static java.util.Arrays.asList;
import static lombok.AccessLevel.PRIVATE;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Random;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.SimpleType;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;

import lombok.NoArgsConstructor;
import ua.timan.invoice.domain.PackingItem;
import ua.timan.invoice.domain.PackingList;
import ua.timan.invoice.domain.Product;
import ua.timan.invoice.domain.ProductGroup;
import ua.timan.invoice.domain.Provider;
import ua.timan.invoice.domain.Storage;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@NoArgsConstructor(access = PRIVATE)
public final class TestDataFactory {

	public static final ObjectMapper MAPPER = new ObjectMapper();

	public static final String FIXTURES_PATH = "fixtures" + File.separator;

	public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

	static {
		MAPPER.registerModule(new JSR310Module());
	}

	private static final PodamFactory PODAM_FACTORY = new PodamFactoryImpl();

	public static InputStream getResourceAsStream(String fileName) throws IOException {
		return TestDataFactory.class.getClassLoader().getResourceAsStream(fileName);
	}

	public static byte[] getResourceAsBytes(String fileName) throws IOException {
		try (InputStream in = getResourceAsStream(fileName); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
			byte[] buffer = new byte[1024];
			int length;
			while ((length = in.read(buffer)) != -1) {
				out.write(buffer, 0, length);
			}
			return out.toByteArray();
		}
	}

	public static String getResourceAsString(String fileName, Charset charset) throws IOException {
		return new String(getResourceAsBytes(fileName), charset);
	}

	public static String getResourceAsString(String fileName) throws IOException {
		return getResourceAsString(fileName, DEFAULT_CHARSET);
	}

	public static String getFixture(String fileName) throws IOException {
		return getResourceAsString(FIXTURES_PATH + fileName);
	}

	public static PackingList createPackingList() {
		return PODAM_FACTORY.manufacturePojo(PackingList.class);
	};

	public static List<PackingList> createPackingLists() {
		return asList(createPackingList(), createPackingList());
	};

	public static List<Storage> createStorages() throws IOException {
		return MAPPER.readValue(getFixture("Storages.json"),
				CollectionType.construct(List.class, SimpleType.construct(Storage.class)));
	}

	public static Storage createStorage() throws IOException {
		return getRandomItem(createStorages());
	}

	public static List<ProductGroup> createProductGroups() throws IOException {
		return MAPPER.readValue(getFixture("ProductGroups.json"),
				CollectionType.construct(List.class, SimpleType.construct(ProductGroup.class)));
	}

	public static ProductGroup createProductGroup() throws IOException {
		return getRandomItem(createProductGroups());
	}

	public static List<Provider> createProviders() throws IOException {
		return MAPPER.readValue(getFixture("Providers.json"),
				CollectionType.construct(List.class, SimpleType.construct(Provider.class)));
	}

	public static Provider createProvider() throws IOException {
		return getRandomItem(createProviders());
	}

	public static List<Product> createProducts() throws IOException {
		return MAPPER.readValue(getFixture("Products.json"),
				CollectionType.construct(List.class, SimpleType.construct(Product.class)));
	}

	public static Product createProduct() throws IOException {
		return getRandomItem(createProducts());
	}
	
	public static List<PackingItem> createPackingItems() throws IOException {
		return MAPPER.readValue(getFixture("PackingItems.json"),
				CollectionType.construct(List.class, SimpleType.construct(PackingItem.class)));
	}

	public static PackingItem createPackingItem() throws IOException {
		return getRandomItem(createPackingItems());
	}

	private static <T> T getRandomItem(List<T> list) {
		return list.get(new Random().nextInt(list.size()));
	}
}
