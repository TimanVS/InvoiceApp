package ua.timan.invoice.controller;

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

import ua.timan.invoice.domain.ProductGroup;
import ua.timan.invoice.service.ProductService;

@Controller
public class ProductGroupController {

	private static final String ROOT_PATH = "/productGroups";

	@Autowired
	private ProductService groupService;

	@RequestMapping(ROOT_PATH)
	@ResponseBody
	public List<ProductGroup> getAll() {
		return groupService.getAllProductGroups();
	}

	@RequestMapping(ROOT_PATH + "/{id}")
	@ResponseBody
	public ProductGroup getById(@PathVariable("id") int id) {
		return groupService.getProductGroup(id);
	}

	@RequestMapping(value = ROOT_PATH + "/{id}", method = DELETE)
	@ResponseBody
	public void deleteById(@PathVariable("id") int id) {
		groupService.deleteProductGroup(id);
	}

	@RequestMapping(value = ROOT_PATH, method = POST)
	@ResponseBody
	public ProductGroup add(@RequestBody ProductGroup group) {
		return groupService.createProductGroup(group);
	}

	@RequestMapping(value = ROOT_PATH, method = PUT)
	@ResponseBody
	public ProductGroup update(@RequestBody ProductGroup group) {
		return groupService.updateProductGroup(group);
	}
	
	@ExceptionHandler
	void handleIllegalArgumentException(IllegalArgumentException e, HttpServletResponse response) throws IOException {
	    response.sendError(HttpStatus.BAD_REQUEST.value());
	}

}
