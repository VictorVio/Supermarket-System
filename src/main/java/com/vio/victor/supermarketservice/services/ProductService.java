package com.vio.victor.supermarketservice.services;

import com.vio.victor.supermarketservice.models.entities.Product;
import com.vio.victor.supermarketservice.models.vos.ProductVO;
import com.vio.victor.supermarketservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@Service // Declara que é um Service.
public class ProductService {

    @Autowired // Preenche o valor da variavel automaticamente.
    private ProductRepository repository;

    public void registerProduct(Product registerProduct) {
        repository.save(registerProduct);
    }

    public void editProduct(Product editProduct) throws ChangeSetPersister.NotFoundException {
        Optional<Product> findProduct = repository.findById(editProduct.getId());
        if(findProduct.isPresent()) {
            repository.save(editProduct);
        }else {
            throw new ChangeSetPersister.NotFoundException();
        }
    }

    public void deleteProductById(Long id) {
        repository.deleteById(id);
    }

    public Product searchProductById(Long id) throws ChangeSetPersister.NotFoundException {
        Optional<Product> findProduct = repository.findById(id);
        if(findProduct.isPresent()) {
            return findProduct.get();
        }
        throw new ChangeSetPersister.NotFoundException();
    }

    public List<ProductVO> searchProductByName(String name) throws ChangeSetPersister.NotFoundException {
        List<ProductVO> findProduct = repository.findByName(name);
        if(!findProduct.isEmpty()) {
            return findProduct;
        }
        throw new ChangeSetPersister.NotFoundException();
    }
}

