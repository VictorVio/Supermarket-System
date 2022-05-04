package com.vio.victor.supermarketservice.controllers;

import com.vio.victor.supermarketservice.models.entities.AbstractEntity;
import com.vio.victor.supermarketservice.models.entities.Product;
import com.vio.victor.supermarketservice.services.AbstractService;
import com.vio.victor.supermarketservice.services.ProductService;
import org.hibernate.event.internal.AbstractSaveEventListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

public abstract class AbstractController<E extends AbstractEntity,S extends AbstractService> {
    @Autowired
    private S service;

    @PostMapping("/register")
    public void registerEntity(@RequestBody E registerEntity){
        service.registerEntity(registerEntity);
    }

    @PutMapping("/edit")
    public ResponseEntity editEntity(@RequestBody E editEntity){
        try{
            service.editEntity(editEntity);
            return new ResponseEntity(HttpStatus.OK);

        }catch (ChangeSetPersister.NotFoundException e){
            return new ResponseEntity<>("Entity not found or not registered", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEntity (@PathVariable Long id){
        service.deleteEntityById(id);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity searchEntity(@PathVariable Long id){
        try{
            return new ResponseEntity(service.searchEntityById(id), HttpStatus.OK);

        }catch (ChangeSetPersister.NotFoundException e){
            return new ResponseEntity<>("Entity not found or not registered", HttpStatus.NOT_FOUND);
        }
    }
}
