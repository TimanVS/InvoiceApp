package ua.timan.invoice.service;

import static org.junit.Assert.assertEquals;
import static ua.timan.invoice.test.TestDataFactory.createPackingList;

import java.io.IOException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ua.timan.invoice.domain.PackingList;
import ua.timan.invoice.test.AbstractSpringTest;

public class PackingListServiceTest extends AbstractSpringTest {

    @Autowired
    private PackingListService pLService;

    @Test
    public void shouldCreatePackingList() throws IOException {
        PackingList entity = createPackingList();
        PackingList result = pLService.createPackingList(entity);

        entity.setId(result.getId());
        assertEquals(entity, result);
    }

}
