package com.example.productservice.repositories;

import com.example.productservice.models.CustomQueries;
import com.example.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    /*
        This is the way to query on attribute of attribute.
     */
    List<Product> findAllByCategory_Subcategories_SurnameEquals(String surname);

    /*
        JPA Queries - Mix of SQL + JPA
        Equivalent Query: SELECT * FROM Product p Where p.id = ?
     */
    @Query(
            "select p " +
                    "from Product p " +
                    "where p.category.subcategories.surname = :categorySurname"
    )
    List<Product> myCustomMethodforJPAQL(@Param("categorySurname") String categorySurname);

    /*
        Native SQL Queries
     */
    @Query(
            value = CustomQueries.GET_PRODUCTS_WITH_SUBCATEGORY_NAME,
            nativeQuery = true
    )
    List<Product> myCustomMethodforNativeSQL();
}
