package ua.timan.invoice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ua.timan.invoice.domain.PackingList;
import ua.timan.invoice.service.PackingService;

@Controller
public class PackingListController {
	
	public static final String P_LISTS = "/p_lists";
	
	@Autowired
	private PackingService listService;
	
	@RequestMapping(P_LISTS)
	@ResponseBody
	public List<PackingList> getAll(){
		return listService.getAllPackingLists();
	}
	
}
