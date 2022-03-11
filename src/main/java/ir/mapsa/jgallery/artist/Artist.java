package ir.mapsa.jgallery.artist;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="Artist")
public class Artist {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "artist_name")
    private String name;
    @Column(name = "artist_name")
    private Integer age;
}
