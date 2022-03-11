package ir.mapsa.jgallery.artwork;


import com.sun.istack.NotNull;
import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class ArtworkDTO {

    private Long id;
    @NotNull
    @Size(min = 3,max = 10)
    private String name;
    @NotNull
    @Size(min = 3,max = 10)
    private Long price;
    @NotNull
    @Size(min = 3,max = 10)
    private Double size;
}
