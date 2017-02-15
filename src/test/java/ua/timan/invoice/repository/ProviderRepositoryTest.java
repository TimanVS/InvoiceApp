package ua.timan.invoice.repository;

import static ua.timan.invoice.test.TestDataFactory.createProvider;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Getter;
import ua.timan.invoice.domain.Provider;

public class ProviderRepositoryTest extends AbstractRepositoryTest<Provider, ProviderRepository> {

    @Getter
    @Autowired
    private ProviderRepository repository;

    @Override
    protected Provider createEntity() throws Exception {
        return createProvider();
    }

}
