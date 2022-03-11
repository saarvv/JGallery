package ir.mapsa.jgallery.base;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface GenericRepository<T,L> extends PagingAndSortingRepository<T,L> {
}
