package com.vio.victor.supermarketservice.controllers;

import com.vio.victor.supermarketservice.models.entities.Product;
import com.vio.victor.supermarketservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController // Informa que existem URLS a serem mapeadas dentro da classe.
@RequestMapping("/product") // Informa qual a URL da classe.

public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/register") // Informa qual a URL do metodo, e que o tipo de comunicação é Post.
    //@RequestBody -> Informa que a variavel será requerida no corpo da requisição
    public void registerProduct(@RequestBody Product registerProduct){
        productService.registerProduct(registerProduct);
    }

    @PutMapping("/edit") // Informa qual a URL do metodo, e que o tipo de comunicação é Put.
    public ResponseEntity editProduct(@RequestBody Product editProduct){
        try{
            productService.editProduct(editProduct);
            return new ResponseEntity(HttpStatus.OK);

        }catch (ChangeSetPersister.NotFoundException e){
            return new ResponseEntity<>("Product not found or not registered", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}") // Informa qual a URL do metodo, e que o tipo de comunicação é Delete.
    public void deleteProduct (@PathVariable Long id){
        productService.deleteProductById(id);
    }

    @GetMapping("/search/{id}") // Informa qual a URL do metodo, e que o tipo de comunicação é Get.
    public ResponseEntity searchProduct(@PathVariable Long id){
        try{
            return new ResponseEntity(productService.searchProductById(id), HttpStatus.OK);

        }catch (ChangeSetPersister.NotFoundException e){
         return new ResponseEntity<>("Product not found or not registered", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search") // Informa qual a URL do metodo, e que o tipo de comunicação é Get.
    public ResponseEntity searchProduct(@PathParam("name") String name){
        try{
            return new ResponseEntity(productService.searchProductByName(name), HttpStatus.OK);

        }catch (ChangeSetPersister.NotFoundException e){
            return new ResponseEntity<>("Product not found or not registered", HttpStatus.NOT_FOUND);
        }
    }
}
