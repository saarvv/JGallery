package ir.mapsa.jgallery.order;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private Long id;

    @Column(name = "houseNumber", nullable = false)
    private int houseNumber;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "avenue", nullable = false)
    private String avenue;

    @Column(name = "plaque", nullable = false)
    private Integer plaque;

    @Column(name = "storey", nullable = true)
    private Integer storey;

    @Column(name = "city", nullable = false)
    private String city;
}