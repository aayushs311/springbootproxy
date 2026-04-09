package com.example.productservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel {
    @Column(nullable = false, unique = true, name = "category_name")
    private String name;
    @Basic(fetch = FetchType.LAZY)
    private String description;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Product> featuredProduct;

    /*
        We have already done M:1 mapping of Product class to its category & we need to specify spring that
        don't do the same kind of mapping(relation) again.

        To specify that we use mappedBy=attribute_name, so spring knows that this relation is already done for
        this attribute.
     */
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
    private List<Product> allProduct;

    @OneToOne
    private Subcategory subcategories;
    private int countOfProducts;
}
