package ir.mapsa.jgallery.artwork;

import ir.mapsa.jgallery.base.GenericRepository;
import ir.mapsa.jgallery.base.GenericService;
import ir.mapsa.jgallery.base.IGenericService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtworkService extends GenericService<Artwork,Long> implements IServiceArtwork {

    private ArtworkRepository artworkRepository;

    public ArtworkService(GenericRepository<Artwork, Long> genericRepository, ArtworkRepository artworkRepository) {
        super(genericRepository);
        this.artworkRepository = artworkRepository;
    }

    @Override
    public List<Artwork> getByArtist(Long artistId) {
        return artworkRepository.findByArtist(artistId);
    }
}
