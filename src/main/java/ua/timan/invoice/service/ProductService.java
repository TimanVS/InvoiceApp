package ua.timan.invoice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.NonNull;
import lombok.Setter;
import ua.timan.invoice.domain.Product;
import ua.timan.invoice.repository.ProductGroupRepository;
import ua.timan.invoice.repository.ProductRepository;

@Service
public class ProductService {

    @Setter(onMethod = @__(@Autowired))
    @NonNull
    private ProductRepository productRepository;

    @Setter(onMethod = @__(@Autowired))
    @NonNull
    private ProductGroupRepository productGroupRepository;

    public Product create(Product arg0) {
        // TODO: 1. add unique id
        return save(arg0);
    }

    private Product save(Product arg0) {
        if (!productGroupRepository.exists(arg0.getGroup().getId())) {
            throw new IllegalArgumentException("No such product group!");
        }
        return productRepository.save(arg0);
    }

}
