package ua.timan.invoice.test;

import static lombok.AccessLevel.PRIVATE;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.NoArgsConstructor;
import ua.timan.invoice.domain.PackingList;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@NoArgsConstructor(access = PRIVATE)
public final class TestDataFactory {

    public static final ObjectMapper MAPPER = new ObjectMapper();

    static PodamFactory factory = new PodamFactoryImpl();

    public static PackingList createPackingList() {
        PackingList myPojo = factory.manufacturePojo(PackingList.class);
        return myPojo;
    };

    public static List<PackingList> createPackingLists() {
        return Arrays.asList(createPackingList(), createPackingList());
    };

}
