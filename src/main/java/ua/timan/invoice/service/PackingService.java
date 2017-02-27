package ua.timan.invoice.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.NonNull;
import lombok.Setter;
import ua.timan.invoice.domain.PackingItem;
import ua.timan.invoice.domain.PackingList;
import ua.timan.invoice.repository.PackingItemRepository;
import ua.timan.invoice.repository.PackingListRepository;

@Service
public class PackingService {

	private static final int DEFAULT_ID = Integer.MIN_VALUE;

	@Setter(onMethod = @__(@Autowired))
	@NonNull
	private PackingListRepository pLRepository;

	@Setter(onMethod = @__(@Autowired))
	@NonNull
	private PackingItemRepository pIRepository;

	@Setter(onMethod = @__(@Autowired))
	@NonNull
	private StaticService staticService;

	@Setter(onMethod = @__(@Autowired))
	@NonNull
	private ProductService productService;

	public PackingList createPackingList(PackingList arg0) {
		if (arg0 == null) {
			throw new IllegalArgumentException("Not null PackingList is expected!");
		}
		arg0.setId(DEFAULT_ID);
		return savePackingList(arg0);
	}

	public PackingItem createPackingItem(PackingItem arg0) {
		if (arg0 == null) {
			throw new IllegalArgumentException("Not null PackingList is expected!");
		}
		arg0.setId(DEFAULT_ID);
		return savePackingItem(arg0);
	}

	private PackingList savePackingList(PackingList arg0) {

		if (arg0.getProvider() == null || !staticService.existsProvider(arg0.getProvider().getId())) {
			throw new IllegalArgumentException("No such provider!");
		}
		if (arg0.getStore() == null || !staticService.existsStorage(arg0.getStore().getId())) {
			throw new IllegalArgumentException("No such storage!");
		}
		return pLRepository.save(arg0);
	}

	private PackingItem savePackingItem(PackingItem arg0) {
		if (arg0.getProduct() == null || !productService.existsProduct(arg0.getProduct().getId())) {
			throw new IllegalArgumentException("Not null product is expected or such product not exists!");
		}
		if (arg0.getQuantity() == null) {
			throw new IllegalArgumentException("Not null quantity is expected!");
		}
		if (arg0.getPrice() == null) {
			throw new IllegalArgumentException("Not null price is expected!");
		}
		return pIRepository.save(arg0);
	}

	@Transactional
	public PackingList getPackingList(int id) {
		return pLRepository.findOne(id);
	}

	public PackingItem getPackingItem(int id) {
		return pIRepository.findOne(id);
	}

	public List<PackingList> getAllPackingLists() {
		List<PackingList> list = new ArrayList<PackingList>();
		Iterable<PackingList> register = pLRepository.findAll();
		// TODO вынести подобные преобразования из Iterable в List в отдельный
		// метод
		for (PackingList pList : register) {
			list.add(pList);
		}
		return list;
	}

	public List<PackingItem> getAllPackingItems() {
		List<PackingItem> list = new ArrayList<PackingItem>();
		Iterable<PackingItem> register = pIRepository.findAll();
		// TODO вынести подобные преобразования из Iterable в List в отдельный
		// метод
		for (PackingItem pList : register) {
			list.add(pList);
		}
		return list;
	}

	@Transactional
	public void deletePackingList(int id) {
		PackingList entity = getPackingList(id);
		List<PackingItem> items = entity.getItems();
		for (PackingItem item : items) {
			deletePackingItem(item.getId());
		}
		pLRepository.delete(id);
	}

	public void deletePackingItem(int id) {
		pIRepository.delete(id);
	}

	@Transactional
	public PackingList updatePackingList(PackingList arg0) {
		if (arg0 == null) {
			throw new IllegalArgumentException("Not null PackingList is expected!");
		}

		if (!pLRepository.exists(arg0.getId())) {
			throw new IllegalArgumentException("PackingList with id " + arg0.getId() + " doesn't exist!");
		}

		return savePackingList(arg0);
	}

	public PackingItem updatePackingItem(PackingItem arg0) {
		if (arg0 == null) {
			throw new IllegalArgumentException("Not null PackingItem is expected!");
		}

		if (!pIRepository.exists(arg0.getId())) {
			throw new IllegalArgumentException("PackingItem with id " + arg0.getId() + " doesn't exist!");
		}

		return savePackingItem(arg0);
	}

	
}
