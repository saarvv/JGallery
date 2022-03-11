package ir.mapsa.jgallery.artist;


import com.sun.istack.NotNull;
import lombok.Data;

import javax.validation.constraints.Size;


@Data
public class ArtistDTO {

    private Long id;
    @NotNull
    @Size(min = 3,max = 10)
    private String name;
    @NotNull
    @Size(max=3)
    private Integer age;
}
