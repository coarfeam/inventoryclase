package com.eamapp.inventoryclase.model.service;

import com.eamapp.inventoryclase.model.entity.Product;
import com.eamapp.inventoryclase.model.repository.IProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService{
    private IProductRepository productRepository;

    private List<Product> products;
    public ProductServiceImpl (IProductRepository productRepository){
        this.productRepository = productRepository;
    }
    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<List<Product>> searchProduct() {
        try{
            products = (List<Product>) productRepository.findAll();
            return new ResponseEntity<>(products, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
