package ua.timan.invoice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ua.timan.invoice.domain.Storage;
import ua.timan.invoice.service.StaticService;

@Controller
public class StorageController {

	public static final String ROOT_PATH = "/storages";

	@Autowired
	private StaticService staticService;

	@RequestMapping(ROOT_PATH)
	@ResponseBody
	public List<Storage> getAll() {
		return staticService.getAllStorages();
	}

	@RequestMapping(ROOT_PATH + "/{id}")
	@ResponseBody
	public Storage getById(@PathVariable("id") int id) {
		return staticService.getStorage(id);
	}

}
