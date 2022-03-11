package ir.mapsa.jgallery.artist;

import ir.mapsa.jgallery.base.GenericMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ArtistMapper extends GenericMapper<Artist,ArtistDTO> {




}
