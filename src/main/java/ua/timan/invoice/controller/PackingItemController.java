package ua.timan.invoice.controller;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import ua.timan.invoice.domain.PackingItem;
import ua.timan.invoice.service.PackingService;

@Controller
public class PackingItemController {

	public static final String ROOT_PATH = "/packingItems";

	@Autowired
	private PackingService packingService;

	@RequestMapping(value = ROOT_PATH, method = PUT)
	@ResponseBody
	public PackingItem updateItem(@RequestBody PackingItem item) {
		return packingService.updatePackingItem(item);
	}

	@RequestMapping(value = ROOT_PATH + "/{id}", method = DELETE)
	@ResponseStatus(NO_CONTENT)
	public void deleteItem(@PathVariable int id) {
		packingService.deletePackingItem(id);
	}

	@RequestMapping(ROOT_PATH + "/{id}")
	@ResponseBody
	public PackingItem getItem(@PathVariable int id) {
		return packingService.getPackingItem(id);
	}

}
