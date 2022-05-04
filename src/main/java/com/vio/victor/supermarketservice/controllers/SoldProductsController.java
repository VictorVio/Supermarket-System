package com.vio.victor.supermarketservice.controllers;

import com.vio.victor.supermarketservice.models.entities.SoldProducts;
import com.vio.victor.supermarketservice.services.SoldProductsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sold")
public class SoldProductsController extends AbstractController<SoldProducts, SoldProductsService>{
}
