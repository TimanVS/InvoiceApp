package ua.timan.invoice.service;

import static ua.timan.invoice.utils.InvoiceUtils.toList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.NonNull;
import lombok.Setter;
import ua.timan.invoice.domain.Provider;
import ua.timan.invoice.domain.Storage;
import ua.timan.invoice.repository.ProviderRepository;
import ua.timan.invoice.repository.StorageRepository;

@Service
public class StaticService {

	@Setter(onMethod = @__(@Autowired))
	@NonNull
	private ProviderRepository providerRepository;

	@Setter(onMethod = @__(@Autowired))
	@NonNull
	private StorageRepository storageRepository;

	public boolean existsProvider(int id) {
		return providerRepository.exists(id);
	}

	public boolean existsStorage(int id) {
		return storageRepository.exists(id);
	}

	public Provider getProvider(int id) {
		return providerRepository.findOne(id);
	}

	public Storage getStorage(int id) {
		return storageRepository.findOne(id);
	}

	public List<Storage> getAllStorages() {
		return toList(storageRepository.findAll());
	}

	public List<Provider> getAllProviders() {
		return toList(providerRepository.findAll());
	}

}
