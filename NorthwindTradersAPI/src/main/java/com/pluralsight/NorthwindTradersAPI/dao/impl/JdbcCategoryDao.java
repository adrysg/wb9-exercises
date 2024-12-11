package com.pluralsight.NorthwindTradersAPI.dao.impl;

import com.pluralsight.NorthwindTradersAPI.dao.interfaces.CategoryDao;
import com.pluralsight.NorthwindTradersAPI.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCategoryDao implements CategoryDao {

    private DataSource dataSource;

    @Autowired
    public JdbcCategoryDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Category> getAll() {
        List<Category> categories = new ArrayList<>();

        try(Connection connection = dataSource.getConnection();
            PreparedStatement pStatement = connection.prepareStatement("SELECT CategoryId, CategoryName FROM categories;");
            ResultSet results = pStatement.executeQuery())
        {
            while (results.next()){
                int categoryId = results.getInt("CategoryId");
                String categoryName = results.getString("CategoryName");
                categories.add(new Category(categoryId, categoryName));
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return categories;
    }

    @Override
    public Category getById(int id) {
        Category category;
        try(Connection connection = dataSource.getConnection();
            PreparedStatement pStatement = connection.prepareStatement("SELECT CategoryId, CategoryName FROM categories;");
        ){
            pStatement.setInt(1, id);
            try(ResultSet results = pStatement.executeQuery()){
                while (results.next()){
                    int categoryId = results.getInt("CategoryId");
                    String categoryName = results.getString("CategoryName");
                    return new Category(categoryId, categoryName);
                }
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return  null;
    }

    @Override
    public Category insert(Category category) {
        return null;
    }
}
