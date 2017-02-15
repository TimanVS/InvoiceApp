package ua.timan.invoice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.NonNull;
import lombok.Setter;
import ua.timan.invoice.domain.Product;
import ua.timan.invoice.domain.ProductGroup;
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

    public Product createProduct(Product arg0) {
        if (arg0 == null) {
            throw new IllegalArgumentException("Not null Product is expected!");
        }
        return saveProduct(arg0);
    }

    public ProductGroup createProductGroup(ProductGroup arg0) {
        if (arg0 == null) {
            throw new IllegalArgumentException("Not null ProductGroup is expected!");
        }
        return saveProductGroup(arg0);
    }

    private ProductGroup saveProductGroup(ProductGroup arg0) {
        if (arg0 == null) {
            throw new IllegalArgumentException("Not null ProductGroup is expected!");
        }

        Iterable<ProductGroup> productGroups = productGroupRepository.findByName(arg0.getName());
        for (ProductGroup group : productGroups) {
            if (group.getName().equals(arg0.getName())) {
                throw new IllegalArgumentException("Such product group already exists!");
            }
        }
        return productGroupRepository.save(arg0);
    }

    private Product saveProduct(Product arg0) {
        Iterable<Product> products = productRepository.findByBarcode(arg0.getBarcode());
        // TODO что если ты меняешь существующий продукт? При этом у тебя уже
        // имеется сущность в БД с таким же Barcode, но ты меняешь другие поля.
        // Так же возможна ситуация, когда ты меняешь Barcode, но на тот, что
        // имеется у другой сущности, с другим id. Пиши тесты и правь код
        for (Product product : products) {
            if (product.getBarcode().equals(arg0.getBarcode())) {
                throw new IllegalArgumentException("Such product already exists!");
            }
        }
        // TODO arg0.getGroup() может дать null. Добавь проверку.
        if (!productGroupRepository.exists(arg0.getGroup().getId())) {
            throw new IllegalArgumentException("No such product group!");
        }
        return productRepository.save(arg0);
    }

    public Product getProduct(int id) {
        return productRepository.findOne(id);
    }

    public ProductGroup getProductGroup(int id) {
        return productGroupRepository.findOne(id);
    }

    public Product updateProduct(Product arg0) {
        if (arg0 == null) {
            throw new IllegalArgumentException("Not null Product is expected!");
        }
        if (!productRepository.exists(arg0.getId())) {
            throw new IllegalArgumentException("Product with id " + arg0.getId() + " doesn't exist!");
        }
        return saveProduct(arg0);
    }

    public ProductGroup updateProductGroup(ProductGroup arg0) {
        if (arg0 == null) {
            throw new IllegalArgumentException("Not null ProductGroup is expected!");
        }
        if (!productGroupRepository.exists(arg0.getId())) {
            throw new IllegalArgumentException("ProductGroup with id " + arg0.getId() + " doesn't exist!");
        }
        return saveProductGroup(arg0);
    }

    public void deleteProduct(int id) {
        productRepository.delete(id);
    }

    public void deleteProductGroup(int id) {
        productGroupRepository.delete(id);
    }

    public List<Product> getAllProducts() {
        List<Product> listProduct = new ArrayList<Product>();
        Iterable<Product> products = productRepository.findAll();
        for (Product product : products) {
            listProduct.add(product);
        }
        return listProduct;
    }

    public List<ProductGroup> getAllProductGroups() {
        List<ProductGroup> listGroup = new ArrayList<ProductGroup>();
        Iterable<ProductGroup> groups = productGroupRepository.findAll();
        for (ProductGroup group : groups) {
            listGroup.add(group);
        }
        return listGroup;
    }

}
