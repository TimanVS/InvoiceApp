package ua.timan.invoice.service;

import static org.springframework.util.CollectionUtils.isEmpty;
import static ua.timan.invoice.utils.InvoiceUtils.toList;

import java.math.BigDecimal;
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
	private PackingListRepository listRepository;

	@Setter(onMethod = @__(@Autowired))
	@NonNull
	private PackingItemRepository itemRepository;

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
		createPackingItems(arg0.getItems());
		arg0.setId(DEFAULT_ID);
		return savePackingList(arg0);
	}

	private void createPackingItems(List<PackingItem> items) {
		if (isEmpty(items)) {
			return;
		}
		for (int i = 0; i < items.size(); i++) {
			items.set(i, createPackingItem(items.get(i)));
		}
	}

	private PackingItem createPackingItem(PackingItem arg0) {
		if (arg0 == null) {
			throw new IllegalArgumentException("Not null PackingItem is expected!");
		}
		arg0.setId(DEFAULT_ID);
		return savePackingItem(arg0);
	}

	@Transactional
	public PackingItem addPackingItem(int id, PackingItem item) {
		if (!listRepository.exists(id)) {
			throw new IllegalArgumentException("Can't find PackingList with id " + id + "!");
		}
		PackingList list = listRepository.findOne(id);
		PackingItem result = createPackingItem(item);
		list.getItems().add(result);
		savePackingList(list);
		return result;
	}

	private PackingList savePackingList(PackingList arg0) {
		if (arg0.getProvider() == null || !staticService.existsProvider(arg0.getProvider().getId())) {
			throw new IllegalArgumentException("The object 'Provider' is not found!!");
		}
		if (arg0.getStore() == null || !staticService.existsStorage(arg0.getStore().getId())) {
			throw new IllegalArgumentException("The object 'Storage' is not found!");
		}
		return listRepository.save(arg0);
	}

	private PackingItem savePackingItem(PackingItem arg0) {
		if (arg0.getProduct() == null || !productService.existsProduct(arg0.getProduct().getId())) {
			throw new IllegalArgumentException("Not null product is expected or such product not exists!");
		}
		if (arg0.getQuantity() == null || arg0.getQuantity() == BigDecimal.valueOf(0)) {
			throw new IllegalArgumentException("Not null quantity is expected! Enter the quantity!");
		}
		if (arg0.getPrice() == null) {
			throw new IllegalArgumentException("Not null price is expected!");
		}
		return itemRepository.save(arg0);
	}

	@Transactional
	public PackingList getPackingList(int id) {
		return listRepository.findOne(id);
	}

	public PackingItem getPackingItem(int id) {
		return itemRepository.findOne(id);
	}

	public List<PackingList> getAllPackingLists() {
		return toList(listRepository.findAll());
	}

	@Transactional
	public void deletePackingList(int id) {
		if (!listRepository.exists(id)) {
			throw new IllegalArgumentException("Can't find packing list with id " + id + "!");
		}
		PackingList entity = getPackingList(id);
		List<PackingItem> items = entity.getItems();
		for (PackingItem item : items) {
			deletePackingItem(item.getId());
		}
		listRepository.delete(id);
	}

	public void deletePackingItem(int id) {
		if (!itemRepository.exists(id)) {
			throw new IllegalArgumentException("Can't find item with id " + id + "!");
		}
		itemRepository.delete(id);
	}

	@Transactional
	public PackingList updatePackingList(PackingList arg0) {
		if (arg0 == null) {
			throw new IllegalArgumentException("Not null PackingList is expected!");
		}

		if (!listRepository.exists(arg0.getId())) {
			throw new IllegalArgumentException("PackingList with id " + arg0.getId() + " doesn't exist!");
		}

		return savePackingList(arg0);
	}

	public PackingItem updatePackingItem(PackingItem arg0) {
		if (arg0 == null) {
			throw new IllegalArgumentException("Not null PackingItem is expected!");
		}

		if (!itemRepository.exists(arg0.getId())) {
			throw new IllegalArgumentException("PackingItem with id " + arg0.getId() + " doesn't exist!");
		}

		return savePackingItem(arg0);
	}

	public boolean existsPackingList(int id) {
		return listRepository.exists(id);
	}

	public boolean existsPackingItem(int id) {
		return itemRepository.exists(id);
	}

}
