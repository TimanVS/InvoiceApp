package ua.timan.invoice.repository;

import org.springframework.data.repository.CrudRepository;

import ua.timan.invoice.domain.PackingList;

public interface PackingListRepository extends CrudRepository<PackingList, Integer> {

}
