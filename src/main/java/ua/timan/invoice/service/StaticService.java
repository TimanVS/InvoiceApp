package ua.timan.invoice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.NonNull;
import lombok.Setter;
import ua.timan.invoice.domain.Product;
import ua.timan.invoice.domain.Provider;
import ua.timan.invoice.domain.Storage;
import ua.timan.invoice.repository.ProviderRepository;
import ua.timan.invoice.repository.StorageRepository;

@Service
public class StaticService extends GetAllList<ConvertToList>{
	
	@Setter(onMethod = @__(@Autowired))
	@NonNull
	private ProviderRepository providerRepository;

	@Setter(onMethod = @__(@Autowired))
	@NonNull
	private StorageRepository storageRepository;
	
	@Autowired
	GetAllList gal;
	
	public boolean existsProvider(int id){
		if (!providerRepository.exists(id)){
			return false;
		}
		return true;
	}
	
	public boolean existsStorage(int id){
		if (!storageRepository.exists(id)){
			return false;
		}
		return true;
	}
    
    
	public Provider getProvider(int id) {
		return providerRepository.findOne(id);
	}
	
	public Storage getStorage(int id) {
		return storageRepository.findOne(id);
	}
	
	public List<Storage> getAllStorages() {
		List<Storage> list = gal.convertFromIterableToList();
		return list;
	}
	
	public List<Provider> getAllProviders() {
		List<Provider> list = gal.convertFromIterableToList();
		return list;
	}
	
}
