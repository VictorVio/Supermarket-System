package com.vio.victor.supermarketservice.repositories;

import com.vio.victor.supermarketservice.models.entities.Product;
import com.vio.victor.supermarketservice.models.vos.ProductVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT new com.vio.victor.supermarketservice.models.vos.ProductVO(p.name, p.quantity, p.unity, p.sellPrice) FROM Product p WHERE p.name like %:name%")
    List<ProductVO> findByName (@Param("name") String name);

}
