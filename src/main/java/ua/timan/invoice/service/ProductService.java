package ua.timan.invoice.service;

import java.util.ArrayList;
import java.util.List;

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
		// TODO: 1. add unique id Решение: @GeneratedValue(strategy =
		// GenerationType.IDENTITY)
		return save(arg0);
	}

	public Product save(Product arg0) {
		Iterable<Product> products = productRepository.findAll();
		for (Product product : products) {
			if (product.getBarcode().equals(arg0.getBarcode())) {
				throw new IllegalArgumentException("Such product already exists!");
			}
		}
		if (!productGroupRepository.exists(arg0.getGroup().getId())) {
			throw new IllegalArgumentException("No such product group!");
		}
		return productRepository.save(arg0);
	}

	public Product get(int id) {
		return productRepository.findOne(id);
	}

	public Product update(Product arg0) {
		Product value = get(arg0.getId());
		value.setBarcode(arg0.getBarcode());
		value.setName(arg0.getName());
		value.setGroup(arg0.getGroup());
		value.setMeasure(arg0.getMeasure());
		return save(value);
	}

	public void delete(int id) {
		productRepository.delete(id);
	}

	public List<Product> getAllProducts() {
		List<Product> listProduct = new ArrayList<Product>();
		Iterable<Product> products = productRepository.findAll();
		for (Product product : products) {
			listProduct.add(product);
		}
		return listProduct;
	}

}
