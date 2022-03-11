package ir.mapsa.jgallery.artwork;

import ir.mapsa.jgallery.base.GenericMapper;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ArtworkMapper extends GenericMapper<Artwork,ArtworkDTO> {


}
