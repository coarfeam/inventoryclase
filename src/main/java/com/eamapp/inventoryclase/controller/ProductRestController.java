package com.eamapp.inventoryclase.controller;

import com.eamapp.inventoryclase.model.entity.Category;
import com.eamapp.inventoryclase.model.entity.Product;
import com.eamapp.inventoryclase.model.service.IProductService;
import com.eamapp.inventoryclase.util.Util;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/")
public class ProductRestController {
    public IProductService productService;

    @GetMapping("products")
    public ResponseEntity<List<Product>> searchProducts(){
        return productService.searchProduct();
    }

    @PostMapping("products")
    public ResponseEntity<List<Product>> saveProducts(
            @RequestParam("picture") MultipartFile picture,
            @RequestParam("name") String name,
            @RequestParam("price") double price,
            @RequestParam("quantity") int quantity,
            @RequestParam("categoryId") Long categoryId
            ) throws IOException {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setQuantity(quantity);
        product.setPicture(Util.compressZLib(picture.getBytes()));
        return productService.save(product, categoryId);
    }
}
