package com.vio.victor.supermarketservice.models.vos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vio.victor.supermarketservice.models.enums.ProductUnity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class ProductVO {
    @JsonProperty("Product Name")
    private String name;
    @JsonProperty("Stock quantity")
    private BigDecimal quantity;
    @JsonProperty("Unity type")
    private ProductUnity unity;
    @JsonProperty("Price")
    private BigDecimal sellPrice;

    public ProductVO(String name, BigDecimal quantity, ProductUnity unity, BigDecimal sellPrice) {
        this.name = name;
        this.quantity = quantity;
        this.unity = unity;
        this.sellPrice = sellPrice;
    }
}
