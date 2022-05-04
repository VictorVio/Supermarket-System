package com.vio.victor.supermarketservice.repositories;

import com.vio.victor.supermarketservice.models.entities.SoldProducts;
import com.vio.victor.supermarketservice.services.SoldProductsService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoldProductsRepository extends JpaRepository<SoldProducts, Long> {
}
