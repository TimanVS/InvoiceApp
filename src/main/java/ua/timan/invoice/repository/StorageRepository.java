package ua.timan.invoice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ua.timan.invoice.domain.Storage;

@Repository
public interface StorageRepository extends CrudRepository<Storage, Integer> {

}
