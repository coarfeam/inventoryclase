package com.eamapp.inventoryclase.model.repository;

import com.eamapp.inventoryclase.model.entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryRepository extends CrudRepository<Category, Long> {
}
