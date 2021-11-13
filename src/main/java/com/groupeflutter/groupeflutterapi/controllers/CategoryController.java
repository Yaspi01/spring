package com.groupeflutter.groupeflutterapi.controllers;

import com.groupeflutter.groupeflutterapi.Model.Category;
import com.groupeflutter.groupeflutterapi.repositories.CategoryRepository;
import com.groupeflutter.groupeflutterapi.services.CategoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/category")
public class CategoryController
{
    @Autowired
    CategoryServiceImp categoryServiceImp;
    @Autowired
    CategoryRepository categoryRepository;

    @PostMapping("/addCategory")
    public String addCategory(@RequestBody Category category)
    {
        return categoryServiceImp.addCategory(category);
    }

    @GetMapping("/getAllCategory")
    public List<Category> getAllCategory()
    {
        return categoryServiceImp.getAllCategory();
    }

    @GetMapping(path = "/photo{id}")
    public byte[] getPhoto(@PathVariable("id") Long id)throws Exception{
        Category c = categoryRepository.findById(id).get();
        return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/panneaux/categories/"+c.getPhoto()));
    }
}
