package com.eamapp.inventoryclase.model.service;

import com.eamapp.inventoryclase.model.entity.Category;
import com.eamapp.inventoryclase.model.entity.Product;
import com.eamapp.inventoryclase.model.repository.ICategoryRepository;
import com.eamapp.inventoryclase.model.repository.IProductRepository;
import com.eamapp.inventoryclase.util.Util;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService{
    private final IProductRepository productRepository;
    private ICategoryRepository categoryRepository;

    private final List<Product> products = new ArrayList<>();
    public ProductServiceImpl (IProductRepository productRepository, ICategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<List<Product>> searchProduct() {
        List<Product> listAux;
        try{
            listAux = (List<Product>) productRepository.findAll();
            if (listAux.size() > 0){
                //programacion reactiva
                listAux.forEach(p -> {
                    byte[] imageDescompressed = Util.decompressZLib(p.getPicture());
                    p.setPicture(imageDescompressed);
                    products.add(p);
                });
            }else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Product>> save(Product product, Long categorId) {

        try{
            Optional<Category> category = categoryRepository.findById(categorId);
            if (category.isPresent()){
                product.setCategory(category.get());
            }
            else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            Product productSaved = productRepository.save(product);
            if (productSaved != null){
                products.add(productSaved);
            }
            else {
                new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
