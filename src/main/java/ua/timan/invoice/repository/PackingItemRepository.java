package ua.timan.invoice.repository;

import org.springframework.data.repository.CrudRepository;

import ua.timan.invoice.domain.PackingItem;

public interface PackingItemRepository extends CrudRepository<PackingItem, Integer> {

}
