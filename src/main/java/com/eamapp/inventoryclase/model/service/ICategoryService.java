package com.eamapp.inventoryclase.model.service;

import com.eamapp.inventoryclase.model.entity.Category;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICategoryService {
    public ResponseEntity<List<Category>> search();
    public ResponseEntity<List<Category>> save(Category category);
}