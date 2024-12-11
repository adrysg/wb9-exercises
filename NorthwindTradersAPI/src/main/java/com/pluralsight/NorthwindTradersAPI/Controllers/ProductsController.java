package com.pluralsight.NorthwindTradersAPI.Controllers;

import com.pluralsight.NorthwindTradersAPI.models.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductsController {

    @RequestMapping(path="/products", method= RequestMethod.GET)
    public List<Product> getProducts(){
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, "Banana", 1, 5.99d));
        products.add(new Product(2, "Apple", 1, 2.99d));
        products.add(new Product(3, "Blue Jeans", 2, 15.99d));
        return products;
    }

    @RequestMapping(path = "/products/{id}", method = RequestMethod.GET)
    public Product getProduct(int id){
        if(id == 1){
            return new Product(1, "Banana", 1, 5.99d);
        }
        else if (id == 2){
            return new Product(2, "Apple", 1, 2.99d);
        }
        return null;
    }
}
