package com.vio.victor.supermarketservice.services;

import com.vio.victor.supermarketservice.models.entities.AbstractEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public abstract class AbstractService<E extends AbstractEntity, R extends JpaRepository> {

    @Autowired
    private R repository;

    public void registerEntity(E registerEntity) {
        repository.save(registerEntity);
    }

    public void editEntity(E editEntity) throws ChangeSetPersister.NotFoundException {
        Optional<E> findEntity = repository.findById(editEntity.getId());
        if(findEntity.isPresent()) {
            repository.save(editEntity);
        }else {
            throw new ChangeSetPersister.NotFoundException();
        }
    }

    public void deleteEntityById(Long id) {
        repository.deleteById(id);
    }

    public E searchEntityById(Long id) throws ChangeSetPersister.NotFoundException {
        Optional<E> findEntity = repository.findById(id);
        if(findEntity.isPresent()) {
            return findEntity.get();
        }
        throw new ChangeSetPersister.NotFoundException();
    }

}
