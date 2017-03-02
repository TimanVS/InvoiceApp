package ua.timan.invoice.repository;

import org.springframework.data.repository.CrudRepository;

import ua.timan.invoice.domain.ProductGroup;

public interface ProductGroupRepository extends CrudRepository<ProductGroup, Integer> {

	Iterable<ProductGroup> findByName(String name);
}
