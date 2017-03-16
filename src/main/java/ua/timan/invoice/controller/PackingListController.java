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

	@RequestMapping(ROOT_PATH + "/{id}")
	@ResponseBody
	public PackingList getById(@PathVariable("id") int id) {
		return packingService.getPackingList(id);
	}

	@RequestMapping(value = ROOT_PATH + "/{id}", method = DELETE)
	@ResponseStatus(NO_CONTENT)
	public void deleteById(@PathVariable("id") int id) {
		packingService.deletePackingList(id);
	}

	@RequestMapping(value = ROOT_PATH, method = POST)
	@ResponseBody
	public PackingList create(@RequestBody PackingList plist) {
		return packingService.createPackingList(plist);
	}

	@RequestMapping(value = ROOT_PATH + "/{id}" + ITEM_PATH, method = POST)
	@ResponseBody
	public PackingItem addItem(@PathVariable int id, @RequestBody PackingItem item) {
		return packingService.addPackingItem(id, item);
	}

	@RequestMapping(value = ROOT_PATH, method = PUT)
	@ResponseBody
	public PackingList update(@RequestBody PackingList plist) {
		return packingService.updatePackingList(plist);
	}

	@ExceptionHandler
	void handleIllegalArgumentException(IllegalArgumentException e, HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.BAD_REQUEST.value());
	}

}
