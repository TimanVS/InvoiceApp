package ua.timan.invoice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.NonNull;
import lombok.Setter;
import ua.timan.invoice.domain.Provider;
import ua.timan.invoice.domain.Storage;
import ua.timan.invoice.repository.ProviderRepository;
import ua.timan.invoice.repository.StorageRepository;

@Service
public class StaticService{
	
	@Setter(onMethod = @__(@Autowired))
	@NonNull
	private ProviderRepository providerRepository;

	@Setter(onMethod = @__(@Autowired))
	@NonNull
	private StorageRepository storageRepository;
	
	
    
	public Provider getProvider(int id) {
		return providerRepository.findOne(id);
	}
	
	public Storage getStorage(int id) {
		return storageRepository.findOne(id);
	}
}
