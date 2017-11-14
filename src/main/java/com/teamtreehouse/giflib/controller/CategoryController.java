package com.teamtreehouse.giflib.controller;

import com.teamtreehouse.giflib.data.CategoryRepository;
import com.teamtreehouse.giflib.data.GifRepository;
import com.teamtreehouse.giflib.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@SuppressWarnings("unused")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private GifRepository gifRepository;


    @RequestMapping("/categories")
    public String listCategories(ModelMap modelMap){
        modelMap.put("categories", categoryRepository.getAllCategories());
        return "categories";
    }


    @RequestMapping("/category/{id}")
    public String category(ModelMap modelMap, @PathVariable int id){

        modelMap.addAttribute("category", categoryRepository.findById(id));

        List<Gif> gifs = gifRepository.findByCategoryId(id);
        modelMap.addAttribute("gifs", gifs);

        return "category";
    }
}
