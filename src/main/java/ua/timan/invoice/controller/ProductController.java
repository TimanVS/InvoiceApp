package ua.timan.invoice.controller;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import ua.timan.invoice.domain.Product;
import ua.timan.invoice.service.ProductService;

@Controller
public class ProductController {

	private static final String ROOT_PATH = "/products";
	@Autowired
	private ProductService productService;

	@RequestMapping(ROOT_PATH)
	@ResponseBody
	public List<Product> getAll() {
		return productService.getAllProducts();
	}

	@RequestMapping(ROOT_PATH + "/{id}")
	@ResponseBody
	public Product getById(@PathVariable("id") int id) {
		return productService.getProduct(id);
	}

	@RequestMapping(value = ROOT_PATH + "/{id}", method = DELETE)
	@ResponseStatus(NO_CONTENT)
	public void deleteById(@PathVariable("id") int id) {
		productService.deleteProduct(id);
	}

	@RequestMapping(value = ROOT_PATH, method = POST)
	@ResponseBody
	public Product create(@RequestBody Product product) {
		return productService.createProduct(product);
	}

	@RequestMapping(value = ROOT_PATH, method = PUT)
	@ResponseBody
	public Product update(@RequestBody Product product) {
		return productService.updateProduct(product);
	}
	
	@ExceptionHandler
	void handleIllegalArgumentException(IllegalArgumentException e, HttpServletResponse response) throws IOException {
	    response.sendError(HttpStatus.BAD_REQUEST.value());
	}
	
}
