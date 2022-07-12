package ee.mihkel.webshop.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
@SequenceGenerator(name = "orderSeq", initialValue = 342334, allocationSize = 1)
public class Order {   //order tabel on reserveeritud (user)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "orderSeq")
    private Long id;
    private double sum;
    private Date createDate;
    private PaymentStatus paymentStatus;

    @ManyToOne          //snachala order - potom person (one)
    private Person person;
    @ManyToMany
    List<Product> products;

    }

