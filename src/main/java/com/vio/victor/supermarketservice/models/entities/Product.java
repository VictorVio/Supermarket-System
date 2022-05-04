package com.vio.victor.supermarketservice.models.entities;

import com.vio.victor.supermarketservice.models.enums.ProductUnity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter // Gera os getters automaticamente.
@Setter // Gera os setters automaticamente.
@Table(name = "products", schema = "sch_supermarket") // Define o nome da tabela.
@Entity
public class Product extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator="seq-gen")
    private Long id;
    private String name;
    private BigDecimal quantity;
    private ProductUnity unity;
    private BigDecimal purchasePrice;
    private BigDecimal sellPrice;
}
