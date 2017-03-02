package ua.timan.invoice.service;

import static ua.timan.invoice.utils.InvoiceUtils.toList;

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

	private static final int DEFAULT_ID = Integer.MIN_VALUE;

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
		arg0.setId(DEFAULT_ID);
		return saveProduct(arg0);
	}

	private Product saveProduct(Product arg0) {
		if (arg0.getBarcode() == null) {
			throw new IllegalArgumentException("Not null barcode is expected!");
		}
		Iterable<Product> products = productRepository.findByBarcode(arg0.getBarcode());
		for (Product product : products) {
			if (product.getId() != arg0.getId()) {
				throw new IllegalArgumentException("Other product with the same barcode already exists!");
			}
		}
		if (arg0.getGroup() == null || !productGroupRepository.exists(arg0.getGroup().getId())) {
			throw new IllegalArgumentException("No such product group!");
		}
		return productRepository.save(arg0);
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
			if (group.getId() != arg0.getId()) {
				throw new IllegalArgumentException("Such product group already exists!");
			}
		}
		return productGroupRepository.save(arg0);
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
		Iterable<Product> products = productRepository.findByGroup(productGroupRepository.findOne(id));
		if (products.iterator().hasNext()) {
			throw new IllegalArgumentException(
					"It's impossible to remove the group because of the presence in it of the goods!");
		}
		productGroupRepository.delete(id);
	}

	public List<Product> getAllProducts() {
		return toList(productRepository.findAll());
	}

	public List<ProductGroup> getAllProductGroups() {
		return toList(productGroupRepository.findAll());
	}

	public boolean existsProduct(int id) {
		return productRepository.exists(id);
	}
	
	public boolean existsProductGroup(int id) {
		return productGroupRepository.exists(id);
	}

}
