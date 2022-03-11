package ir.mapsa.jgallery.base;

import java.util.List;

public interface IGenericService<T,L> {

    List<T> getAll();
    T save(T entity);
    void delete(L id);
    T getById(L id);


}
