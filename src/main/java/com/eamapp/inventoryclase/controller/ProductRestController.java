package com.eamapp.inventoryclase.controller;

import com.eamapp.inventoryclase.model.entity.Product;
import com.eamapp.inventoryclase.model.service.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/")
public class ProductRestController {
    public IProductService productService;
//    public ProductRestController (IProductService productService){
//        this.productService = productService;
//    }
    @GetMapping("products")
    public ResponseEntity<List<Product>> searchProducts(){
        return productService.searchProduct();
    }
}
