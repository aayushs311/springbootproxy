package com.example.productservice.repositories;

import com.example.productservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    /*
        Using Optional means that Category object may or may not be returned.
     */
    Optional<Category> findByNameEquals(String name);
    Category save(Category category);
}
