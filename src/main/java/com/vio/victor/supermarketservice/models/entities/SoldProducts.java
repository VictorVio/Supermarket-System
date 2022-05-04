package com.vio.victor.supermarketservice.models.entities;

import com.vio.victor.supermarketservice.models.enums.PaymentMethod;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Table(name = "sold_products", schema = "sch_supermarket")
@Entity
public class SoldProducts extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator="seq-gen")
    private Long id;
    private Employee seller;
    private List<Product> productList;
    private PaymentMethod paymentMethod;
    private BigDecimal total;
    private BigDecimal profit;

}
