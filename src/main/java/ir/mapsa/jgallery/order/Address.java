package ir.mapsa.jgallery.order;

import javax.persistence.*;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAvenue() {
        return avenue;
    }

    public void setAvenue(String avenue) {
        this.avenue = avenue;
    }

    public int getPlaque() {
        return plaque;
    }

    public void setPlaque(int plaque) {
        this.plaque = plaque;
    }

    public int getStorey() {
        return storey;
    }

    public void setStorey(int storey) {
        this.storey = storey;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}