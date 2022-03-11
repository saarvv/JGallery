package ir.mapsa.jgallery.base;

import ir.mapsa.jgallery.artwork.Artwork;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;


public class GenericService<T,L> implements IGenericService<T,L> {

 private GenericRepository<T,L> genericRepository;

    public GenericService(GenericRepository<T, L> genericRepository) {
        this.genericRepository = genericRepository;
    }

    @Override
    public List<T> getAll() {
        return (List<T>) genericRepository.findAll();
    }

    @Override
    public T save(T entity) {
        return genericRepository.save(entity);
    }

    @Override
    public void delete(L id) {

        genericRepository.deleteById(id);
    }

    @Override
    public T getById(L id) {
        Optional<T> entities = genericRepository.findById(id);
        if (entities.isEmpty()){

          //  throw new NotFoundException("")

        }
        return (T) genericRepository.getClass();
    }
}
