package com.example.productservice.repositories;

import com.example.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    /*
        - save() method also update the row
        - Your request may or may not have id but your response has.
        - JPA will see if a product with that Id exists:
          - If no: CREATE
          - Else: UPDATE
     */
    Product save(Product p);
    List<Product> findAll();
    Optional<Product> findById(long id);
}
