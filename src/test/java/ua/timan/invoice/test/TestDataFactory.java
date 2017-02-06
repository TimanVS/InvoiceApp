package ua.timan.invoice.test;

import static java.util.Arrays.asList;
import static lombok.AccessLevel.PRIVATE;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Random;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.SimpleType;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;

import lombok.NoArgsConstructor;
import ua.timan.invoice.domain.PackingList;
import ua.timan.invoice.domain.Storage;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@NoArgsConstructor(access = PRIVATE)
public final class TestDataFactory {

    public static final ObjectMapper MAPPER = new ObjectMapper();

    public static final String FIXTURES_PATH = "fixtures" + File.separator;

    static {
        MAPPER.registerModule(new JSR310Module());
    }

    private static final PodamFactory PODAM_FACTORY = new PodamFactoryImpl();

    public static InputStream getResource(String fileName) throws IOException {
        return TestDataFactory.class.getClassLoader().getResourceAsStream(fileName);
    }

    public static InputStream getFixture(String fileName) throws IOException {
        return getResource(FIXTURES_PATH + fileName);
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
        List<Storage> storages = createStorages();
        return storages.get(new Random().nextInt(storages.size()));
    }
}
