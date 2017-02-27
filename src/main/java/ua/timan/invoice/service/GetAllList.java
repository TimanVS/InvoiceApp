package ua.timan.invoice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

public class GetAllList <T extends ConvertToList>{
	
	@Autowired
	protected CrudRepository<T, Integer> repository;
	
	public List <T> convertFromIterableToList(){
		List<T> list = new ArrayList<T>();
		Iterable<T> register = repository.findAll();
		for (T item : register) {
			list.add(item);
		}
		return list;
	}

}
