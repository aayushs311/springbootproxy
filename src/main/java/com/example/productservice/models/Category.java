package com.example.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel {
    private String name;
    private String description;
    @OneToMany
    private List<Product> featuredProduct;

    /*
        We have already done M:1 mapping of Product class to its category & we need to specify spring that
        don't do the same kind of mapping(relation) again.

        To specify that we use mappedBy=attribute_name, so spring knows that this relation is already done for
        this attribute.
     */
    @OneToMany(mappedBy = "category")
    private List<Product> allProduct;

    @OneToOne
    private Subcategory subcategories;
}
