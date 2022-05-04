package com.vio.victor.supermarketservice.controllers;

import com.vio.victor.supermarketservice.models.entities.Product;
import com.vio.victor.supermarketservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import javax.xml.ws.Service;

@RestController // Informa que existem URLS a serem mapeadas dentro da classe.
@RequestMapping("/product") // Informa qual a URL da classe.

public class ProductController extends AbstractController<Product, ProductService> {
    @Autowired
    private ProductService productService;

    @GetMapping("/search") // Informa qual a URL do metodo, e que o tipo de comunicação é Get.
    public ResponseEntity searchProduct(@PathParam("name") String name){
        try{
            return new ResponseEntity(productService.searchProductByName(name), HttpStatus.OK);

        }catch (ChangeSetPersister.NotFoundException e){
            return new ResponseEntity<>("Product not found or not registered", HttpStatus.NOT_FOUND);
        }
    }
}
