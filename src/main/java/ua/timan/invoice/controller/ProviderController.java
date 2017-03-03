package ua.timan.invoice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ua.timan.invoice.domain.Provider;
import ua.timan.invoice.service.StaticService;

@Controller
public class ProviderController {
	
	public static final String ROOT_PATH = "/providers";
	
	@Autowired
	private StaticService staticServise;
	
	@RequestMapping(ROOT_PATH)
	@ResponseBody
	public List<Provider> getAll() {
		return staticServise.getAllProviders();
	}
	
	@RequestMapping(ROOT_PATH + "/{id}")
	@ResponseBody
	public Provider getById(@PathVariable("id") int id){
		return staticServise.getProvider(id);
	}

}
