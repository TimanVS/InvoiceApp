package ua.timan.invoice.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ua.timan.invoice.domain.PackingItem;
import ua.timan.invoice.domain.PackingList;
import ua.timan.invoice.service.PackingService;

@Controller
public class PackingListController {

	public static final String ROOT_PATH = "/packings";
	public static final String ITEM_PATH = "/items";

	@Autowired
	private PackingService packingService;

	@RequestMapping(ROOT_PATH)
	@ResponseBody
	public List<PackingList> getAllPackings() {
		return packingService.getAllPackingLists();
	}

	// TODO дописать методы для PackingList-а

	@RequestMapping(value = ROOT_PATH + "/{id}" + ITEM_PATH, method = POST)
	@ResponseBody
	public PackingItem addItem(@PathVariable int id, @RequestBody PackingItem item) {
		// TODO написать реализацию в сервисе
		return packingService.addPackingItem(id, item);
	}

}
