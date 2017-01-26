package ua.timan.invoice.test;

import static lombok.AccessLevel.PRIVATE;

import java.util.Arrays;
import java.util.List;

import lombok.NoArgsConstructor;
import ua.timan.invoice.domain.PackingList;

@NoArgsConstructor(access = PRIVATE)
public final class TestDataFactory {

    public static PackingList createPackingList() {

    };

    public static PackingList createOtherPackingList() {

    };

    public static List<PackingList> createPackingLists() {
        return Arrays.asList(createPackingList(), createOtherPackingList());
    };

}
