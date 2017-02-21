package ua.timan.invoice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.NonNull;
import lombok.Setter;
import ua.timan.invoice.domain.PackingItem;
import ua.timan.invoice.domain.PackingList;
import ua.timan.invoice.repository.PackingItemRepository;
import ua.timan.invoice.repository.PackingListRepository;
import ua.timan.invoice.repository.ProviderRepository;
import ua.timan.invoice.repository.StorageRepository;

@Service
public class PackingListService {

	private static final int DEFAULT_ID = Integer.MIN_VALUE;

	@Setter(onMethod = @__(@Autowired))
	@NonNull
	private PackingListRepository pLRepository;

	@Setter(onMethod = @__(@Autowired))
	@NonNull
	private PackingItemRepository pIRepository;
	
	@Setter(onMethod = @__(@Autowired))
	@NonNull
	private ProviderRepository providerRepository;
	
	@Setter(onMethod = @__(@Autowired))
	@NonNull
	private StorageRepository storageRepository;

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

	public PackingList savePackingList(PackingList arg0) {
		if (arg0 == null) {
			throw new IllegalArgumentException("Not null PackingList is expected!");
		}
		if (arg0.getProvider() == null || !providerRepository.exists(arg0.getProvider().getId())){
			throw new IllegalArgumentException("No such provider!");
		}
		if (arg0.getStore() == null || !storageRepository.exists(arg0.getStore().getId())){
			throw new IllegalArgumentException("No such storage!");
		}
		return pLRepository.save(arg0);
	}
	
	public PackingItem savePackingItem(PackingItem arg0) {
		if (arg0 == null) {
			throw new IllegalArgumentException("Not null PackingItem is expected!");
		}
		return pIRepository.save(arg0);
	}
	

	public PackingList get(int id) {
		return null;
	}

	public List<PackingList> getAll(long offset, long size, boolean asc) {
		return null;
	}

	public void delete(int id) {

	}

	public PackingList update(PackingList arg0) {
		if (arg0 == null) {
			throw new IllegalArgumentException("Not null Product is expected!");
		}

		return savePackingList(arg0);
	}
}
