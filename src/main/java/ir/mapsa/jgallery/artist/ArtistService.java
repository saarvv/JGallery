package ir.mapsa.jgallery.artist;

import ir.mapsa.jgallery.base.GenericRepository;
import ir.mapsa.jgallery.base.GenericService;
import org.springframework.stereotype.Service;

@Service

public class ArtistService extends GenericService<Artist,Long> implements IServiceArtist{

    private ArtistRepository artistRepository;

    public ArtistService(GenericRepository<Artist, Long> genericRepository, ArtistRepository artistRepository) {
        super(genericRepository);
        this.artistRepository = artistRepository;
    }


}
