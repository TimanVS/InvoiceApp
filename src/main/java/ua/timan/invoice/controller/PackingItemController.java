package ua.timan.invoice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ua.timan.invoice.domain.PackingItem;
import ua.timan.invoice.service.PackingService;

@Controller
public class PackingItemController {

	public static final String P_ITEM = "/p_items";

	@Autowired
	private PackingService itemService;

	@RequestMapping(P_ITEM)
	@ResponseBody
	public List<PackingItem> getAll() {
		return itemService.getAllPackingItems();
	}
}
