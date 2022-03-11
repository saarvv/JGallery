package ir.mapsa.jgallery.artist;

import ir.mapsa.jgallery.base.GenericRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends GenericRepository<Artist,Long> {
}
