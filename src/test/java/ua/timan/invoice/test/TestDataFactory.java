package ua.timan.invoice.test;

import static lombok.AccessLevel.PRIVATE;

import java.io.File;
import java.io.IOException;
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
import ua.timan.invoice.utils.InvoiceUtils;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@NoArgsConstructor(access = PRIVATE)
public final class TestDataFactory {

	public static final String JSON_EXT = ".json";

	public static final ObjectMapper MAPPER = new ObjectMapper();

	public static final String FIXTURES_PATH = "fixtures" + File.separator;

	static {
		MAPPER.registerModule(new JSR310Module());
	}

	private static final PodamFactory PODAM_FACTORY = new PodamFactoryImpl();

	public static String getFixture(String fileName) throws IOException {
		return InvoiceUtils.getResourceAsString(FIXTURES_PATH + fileName);
	}

	public static <T> T createPodam(Class<T> classT) {
		return PODAM_FACTORY.manufacturePojo(classT);
	}

	public static List<Storage> createStorages() throws IOException {
		return createEntityList(Storage.class);
	}

	public static Storage createStorage() throws IOException {
		return getRandomItem(createStorages());
	}

	public static List<ProductGroup> createProductGroups() throws IOException {
		return createEntityList(ProductGroup.class);
	}

	private static <T> List<T> createEntityList(Class<T> clazz) throws IOException {
		return MAPPER.readValue(getFixture(createPlural(clazz.getSimpleName()) + JSON_EXT),
				CollectionType.construct(List.class, SimpleType.construct(clazz)));
	}

	private static String createPlural(String objectName) {
		return objectName + "s";
	}

	public static ProductGroup createProductGroup() throws IOException {
		return getRandomItem(createProductGroups());
	}

	public static List<Provider> createProviders() throws IOException {
		return createEntityList(Provider.class);
	}

	public static Provider createProvider() throws IOException {
		return getRandomItem(createProviders());
	}

	public static List<Product> createProducts() throws IOException {
		return createEntityList(Product.class);
	}

	public static Product createProduct() throws IOException {
		return getRandomItem(createProducts());
	}

	public static Product extractLastProduct() throws IOException {
		return getLastItem(createProducts());
	}

	public static List<PackingItem> createPackingItems() throws IOException {
		return createEntityList(PackingItem.class);
	}

	public static PackingItem createPackingItem() throws IOException {
		return getRandomItem(createPackingItems());
	}

	public static List<PackingList> createPackingLists() throws IOException {
		return createEntityList(PackingList.class);
	}

	public static PackingList createPackingList() throws IOException {
		return getRandomItem(createPackingLists());
	}

	public static <T> T getRandomItem(List<T> list) {
		return list.get(new Random().nextInt(list.size()));
	}

	public static <T> T getLastItem(List<T> list) {
		return list != null && !list.isEmpty() ? list.get(list.size() - 1) : null;
	}

}
