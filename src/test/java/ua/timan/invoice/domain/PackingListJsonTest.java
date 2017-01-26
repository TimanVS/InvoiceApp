package ua.timan.invoice.domain;

import static ua.timan.invoice.test.TestDataFactory.MAPPER;
import static ua.timan.invoice.test.TestDataFactory.createPackingList;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PackingListJsonTest {

    @Test
    public void shouldConvertPackingListToJson() throws JsonProcessingException {
        String json = MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(createPackingList());

        log.info(json);
    }
}
