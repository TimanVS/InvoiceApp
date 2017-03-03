package ua.timan.invoice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ua.timan.invoice.domain.ProductGroup;
import ua.timan.invoice.service.ProductService;

@Controller
public class ProductGroupController {
	
	private static final String ROOT_PATH = "/groups";
	
	@Autowired
	private ProductService groupService;
	
	@RequestMapping
	@ResponseBody
	public List<ProductGroup> getAll() {
		return groupService.getAllProductGroups();
	}
	
	@RequestMapping(ROOT_PATH + "/{id}")
	@ResponseBody
	public ProductGroup getById(@PathVariable("id") int id){
		return groupService.getProductGroup(id);
	}
	
	@RequestMapping(ROOT_PATH + "/remove/{id}")
	@ResponseBody
	public void deleteById(@PathVariable("id") int id){
		groupService.deleteProductGroup(id);
	}
	
	@RequestMapping(value = ROOT_PATH + "/add", method = RequestMethod.POST)
	@ResponseBody
	public ProductGroup addGroup(@ModelAttribute("group") ProductGroup group){
		
		if (!groupService.existsProduct(group.getId())){
			groupService.createProductGroup(group);
		}
		
		return groupService.updateProductGroup(group);
	}

}
