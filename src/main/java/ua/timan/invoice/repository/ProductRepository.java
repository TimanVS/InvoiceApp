package ua.timan.invoice.repository;

import org.springframework.data.repository.CrudRepository;

import ua.timan.invoice.domain.Product;
import ua.timan.invoice.domain.ProductGroup;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    Iterable<Product> findByBarcode(String barcode);
    
    Iterable<Product> findByGroup(ProductGroup group);
}
