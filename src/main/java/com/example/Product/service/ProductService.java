package com.example.Product.service;

import com.example.Product.entity.Product;
import com.example.Product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class ProductService {
    private final EntityManager entityManager;

    @Autowired
    ProductRepository productRepository;
    @Autowired
    public ProductService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public List<Product> saveProducts(List<Product> products){
        return productRepository.saveAll(products)  ;
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product getByProductId(int id){
        return productRepository.findByproductId(id);
    }

    public Product getByProductName(String name){
        return productRepository.findByProductName(name);
    }
    @Transactional
    public Product deleteProduct(int id) {
        Product productToRemove = entityManager.find(Product.class, id);
        if (productToRemove != null) {
            entityManager.remove(productToRemove);
        }
          return null;
    }

    public Product updateProduct(int id, Product updatedProduct) {
        Product productToUpdate = getByProductId(id);

            productToUpdate.setProductName(updatedProduct.getProductName());
            productToUpdate.setProductPrice(updatedProduct.getProductPrice());
            productToUpdate.setProductReview(updatedProduct.getProductReview());
            productToUpdate.setPlace(updatedProduct.getPlace());

        return productRepository.save(productToUpdate);
    }

}
