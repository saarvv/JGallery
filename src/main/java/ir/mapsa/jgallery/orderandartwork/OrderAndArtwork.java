package ir.mapsa.jgallery.orderandartwork;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "orderAndArtwork")
public class OrderAndArtwork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_Artwork_id")
    private Long id;

    @Column(name = "artwork_id")
    private Long artworkid;

    @Column(name = "order")
    private Long order;
}
