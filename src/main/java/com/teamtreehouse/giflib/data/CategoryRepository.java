package com.teamtreehouse.giflib.data;

import com.teamtreehouse.giflib.model.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CategoryRepository {

    private static final Logger logger = LoggerFactory.getLogger(CategoryRepository.class);

    private static final List<Category> ALL_CATEGORIES = Arrays.asList(
        new Category(1,  "Technology"),
        new Category(2, "People"),
        new Category(3, "Destruction")
    );


    public List<Category> getAllCategories() {
        logger.info("Requested all categories");
        return ALL_CATEGORIES;
    }

    public Category findById(int id){

        for (Category category : ALL_CATEGORIES) {
            if (category.getId() == id){
                logger.info("Requested category with id: " + id + " returning " + category.toString());
                return category;
            }
        }
        logger.error("Not found category requested with id " + id + " returning null");
        return null;
    }
}
