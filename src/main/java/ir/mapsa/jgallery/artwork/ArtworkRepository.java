package ir.mapsa.jgallery.artwork;

import ir.mapsa.jgallery.artist.Artist;
import ir.mapsa.jgallery.base.GenericRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ArtworkRepository extends GenericRepository<Artwork,Long> {

    List<Artwork> findByArtist(Long artistId);
}
