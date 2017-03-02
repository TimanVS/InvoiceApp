package ua.timan.invoice.test;

import static ua.timan.invoice.test.TestDataFactory.getResourceAsString;

import java.sql.Connection;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TestDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private DataSource dataSource;

    public void onApplicationEvent(ContextRefreshedEvent event) {
        try (Connection connection = dataSource.getConnection(); Statement statement = connection.createStatement()) {
            statement.execute(getResourceAsString("test-data.sql"));
        } catch (Exception ex) {
            log.error("Unnable to load test data!", ex);
        }
    }

}
