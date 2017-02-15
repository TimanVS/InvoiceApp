package ua.timan.invoice.repository;

import static ua.timan.invoice.test.TestDataFactory.createProvider;

import ua.timan.invoice.domain.Provider;

public class ProviderRepositoryTest extends AbstractRepositoryTest<Provider> {

    @Override
    protected Provider createEntity() throws Exception {
        return createProvider();
    }

}
