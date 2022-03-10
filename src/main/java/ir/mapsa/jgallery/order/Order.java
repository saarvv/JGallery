package ir.mapsa.jgallery.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "`order`")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @Column(name = "price")
    private Integer price;

    @Column(name = "status")
    private String status;

    //public List<artWork> artWorks;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date purchaseDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address")
    private Address address;
}
