package com.example.Product.repository;

import com.example.Product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ProductRepository extends JpaRepository<Product,Integer> {


    Product findByproductId(int id);

    Product findByProductName(String name);


    Product deleteByProductId(int id);
}
