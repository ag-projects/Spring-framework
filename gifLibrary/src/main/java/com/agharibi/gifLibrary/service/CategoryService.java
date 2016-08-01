package com.agharibi.gifLibrary.service;

import com.agharibi.gifLibrary.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CategoryService {

    List<Category> findAll();
    Category findById(Long id);
    void save(Category category);
    void delete(Category category);
}
