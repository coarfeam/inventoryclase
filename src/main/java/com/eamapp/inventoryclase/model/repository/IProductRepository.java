package com.eamapp.inventoryclase.model.repository;

import com.eamapp.inventoryclase.model.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IProductRepository extends CrudRepository<Product, Long> {
    //mapstruct - utilizar
    //@Query(value = "select p.* from product p JOIN category c ON p.category_id = c.id", nativeQuery = true)
    //List<Product> findAllProducts();

}
