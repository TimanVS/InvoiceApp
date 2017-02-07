package ua.timan.invoice.repository;

import static ua.timan.invoice.test.TestDataFactory.getResourceAsString;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import ua.timan.invoice.test.AbstractSpringTest;

public abstract class AbstractRepositoryTest extends AbstractSpringTest implements InitializingBean {

    private static boolean testDataInserted = false;

    @Autowired
    private DataSource dataSource;

    @Override
    public void afterPropertiesSet() throws SQLException, IOException {
        if (testDataInserted) {
            return;
        }
        try (Connection connection = dataSource.getConnection(); Statement statement = connection.createStatement()) {
            statement.execute(getResourceAsString("test-data.sql"));
        }
        testDataInserted = true;
    }

}
