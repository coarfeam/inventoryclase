package com.eamapp.inventoryclase.model.repository;

import com.eamapp.inventoryclase.model.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface IProductRepository extends CrudRepository<Product, Long> {
}
