package ir.mapsa.jgallery.base;

import java.util.List;

public interface GenericMapper <E,D>{


    E toEntity(D dto);
    D toDto(E entity);
    List<E> toEntities(List<D> dtos);
    List<D> toDtos(List<E> entities);

}
