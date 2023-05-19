package com.eamapp.inventoryclase.model.service;

import com.eamapp.inventoryclase.model.entity.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IProductService {
    public ResponseEntity<List<Product>> searchProduct();
    public ResponseEntity<List<Product>> save(Product product, Long categorId);
    public ResponseEntity<List<Product>> update(Product product, Long categoryId, Long productId);
}
