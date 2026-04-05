package com.example.productservice.models;

public class CustomQueries {
    public static final String GET_PRODUCTS_WITH_SUBCATEGORY_NAME =
            "SELECT * FROM Product p" +
                    "JOIN Category c on p.category = c.id " +
                    "JOIN Subcategory s" +
                    "WHERE s.categoryId = c.id";
}
