package ua.timan.invoice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ua.timan.invoice.domain.Product;
import ua.timan.invoice.service.ProductService;

@Controller
public class ProductController {
	
	private static final String ROOF_PATH_P = "/products";
	@Autowired
	private ProductService productServise;
	
	@RequestMapping(ROOF_PATH_P)
	@ResponseBody
	public List<Product> getAll() {
		return productServise.getAllProducts();
	}
}
