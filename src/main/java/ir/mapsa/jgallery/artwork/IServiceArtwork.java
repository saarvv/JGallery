package ir.mapsa.jgallery.artwork;


import ir.mapsa.jgallery.base.IGenericService;

import java.util.List;

public interface IServiceArtwork extends IGenericService<Artwork,Long> {

    List<Artwork> getByArtist(Long artistId);
}
