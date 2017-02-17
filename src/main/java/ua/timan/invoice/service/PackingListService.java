package ua.timan.invoice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.NonNull;
import lombok.Setter;
import ua.timan.invoice.domain.PackingList;
import ua.timan.invoice.repository.PackingItemRepository;
import ua.timan.invoice.repository.PackingListRepository;

@Service
public class PackingListService {

	@Setter(onMethod = @__(@Autowired))
	@NonNull
	private PackingListRepository pLRepository;

	@Setter(onMethod = @__(@Autowired))
	@NonNull
	private PackingItemRepository pIGroupRepository;

	public PackingList createPackingList(PackingList arg0) {
		if (arg0 == null) {
			throw new IllegalArgumentException("Not null PackingList is expected!");
		}
		return savePackingList(arg0);
	}

	public PackingList savePackingList(PackingList arg0) {
		// TODO: store to DB
		return pLRepository.save(arg0);
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
