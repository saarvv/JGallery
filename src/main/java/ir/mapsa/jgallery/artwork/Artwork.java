package ir.mapsa.jgallery.artwork;

import ir.mapsa.jgallery.artist.Artist;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Artwork")
public class Artwork {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "artwork_id")
    private Long id;
    @Column(name="artwork_name")
    private String name;
    @Column(name = "artwork_price")
    private Long price;
    @Column(name = "artwork_size")
    private Double size;

    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "artist_id")
    private Artist artistEntity;

}
