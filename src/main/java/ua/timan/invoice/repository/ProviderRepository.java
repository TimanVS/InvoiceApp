package ua.timan.invoice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ua.timan.invoice.domain.Provider;

@Repository
public interface ProviderRepository extends CrudRepository<Provider, Integer> {

}
