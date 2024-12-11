package com.pluralsight.NorthwindTradersAPI.Controllers;

import com.pluralsight.NorthwindTradersAPI.models.Category;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoriesController {

    @RequestMapping(path="/categories", method = RequestMethod.GET)
    public List<Category> getCategories(){
        ArrayList<Category> categories = new ArrayList<>();
        categories.add(new Category(1, "fruit"));
        categories.add(new Category(2, "clothing"));
        return categories;
    }
}