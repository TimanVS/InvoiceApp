package ua.timan.invoice.repository;

import static ua.timan.invoice.test.TestDataFactory.createPackingList;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Getter;
import ua.timan.invoice.domain.PackingList;

public class PackingListRepositoryTest extends AbstractRepositoryTest<PackingList, PackingListRepository> {

    @Getter
    @Autowired
    private PackingListRepository repository;

    @Override
    protected PackingList createEntity() throws Exception {
        return createPackingList();
    }
}
