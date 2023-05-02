package com.eamapp.inventoryclase.controller;

import com.eamapp.inventoryclase.model.entity.Category;
import com.eamapp.inventoryclase.model.service.ICategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/")
public class CategoryRestController {
    private ICategoryService categoryService;

    @GetMapping("categories")
    public ResponseEntity<List<Category>> searchCategories(){
        return categoryService.search();
    }

    @PostMapping("categories")
    public ResponseEntity<List<Category>> saveCategorie(@RequestBody Category category){
        return categoryService.save(category);
    }
}
