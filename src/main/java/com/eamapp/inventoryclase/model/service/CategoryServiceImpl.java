package com.eamapp.inventoryclase.model.service;

import com.eamapp.inventoryclase.model.entity.Category;
import com.eamapp.inventoryclase.model.repository.ICategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CategoryServiceImpl implements ICategoryService{
    private final ICategoryRepository categoryRepository;
    List<Category> categories = new ArrayList<>();

    public CategoryServiceImpl (ICategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<List<Category>> search() {
        try {
            categories = (List<Category>) categoryRepository.findAll();
            return new ResponseEntity<>(categories, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @Transactional
    public ResponseEntity<List<Category>> save(Category category) {
        try {
            Category categorySaved =categoryRepository.save(category);
            categories.add(categorySaved);
            return new ResponseEntity<>(categories, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<Category> searchById(Long id) {
        try {
            Optional<Category> category = categoryRepository.findById(id);
            return category.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
