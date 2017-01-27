package ua.timan.invoice.test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ua.timan.invoice.domain.Storage;
import ua.timan.invoice.repository.StorageRepository;

@Configuration
public class SpringApplicationContext {

    @Bean
    public StorageRepository strageRepository() {
        return new StorageRepository() {

            private Map<Integer, Storage> map = new HashMap<Integer, Storage>();

            @SuppressWarnings("unchecked")
            @Override
            public <S extends Storage> S save(S entity) {
                return (S) map.put(entity.getId(), entity);
            }

            @Override
            public <S extends Storage> Iterable<S> save(Iterable<S> entities) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public Storage findOne(Integer id) {
                return map.get(id);
            }

            @Override
            public boolean exists(Integer id) {
                // TODO Auto-generated method stub
                return false;
            }

            @Override
            public Iterable<Storage> findAll() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public Iterable<Storage> findAll(Iterable<Integer> ids) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public long count() {
                // TODO Auto-generated method stub
                return 0;
            }

            @Override
            public void delete(Integer id) {
                // TODO Auto-generated method stub

            }

            @Override
            public void delete(Storage entity) {
                // TODO Auto-generated method stub

            }

            @Override
            public void delete(Iterable<? extends Storage> entities) {
                // TODO Auto-generated method stub

            }

            @Override
            public void deleteAll() {
                // TODO Auto-generated method stub

            }

        };
    }
}