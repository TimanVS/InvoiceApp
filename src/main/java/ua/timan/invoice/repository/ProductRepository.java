package ua.timan.invoice.repository;

import org.springframework.data.repository.CrudRepository;

import ua.timan.invoice.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
	
	Iterable<Product> findByBarcode(String barcode);

}
