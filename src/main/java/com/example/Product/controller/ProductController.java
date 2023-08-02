package com.example.Product.controller;

import com.example.Product.entity.Product;
import com.example.Product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;
    @PostMapping("/create")
    public String save(@RequestBody Product product){
         productService.save(product);
         return "product was created in database Table";
    }

    @PostMapping("/createAll")
    public List<Product> saveAll(@RequestBody List<Product> products){
        return productService.saveProducts(products);
    }
    @GetMapping("/products")
    public List<Product> findAll(){
        return productService.findAll();
    }
    @GetMapping("/productId/{id}")
    public Product findByProductId(@PathVariable int id){
        return productService.getByProductId(id);
    }
    @GetMapping("/productName/{name}")
    public Product findByProductName(@PathVariable String name){
        return productService.getByProductName(name);
    }
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product updatedItem) {
        return productService.updateProduct(id, updatedItem);
    }


    @DeleteMapping("/delete/{id}")
    public Product deleteByProductId(@PathVariable int id ){
        return productService.deleteProduct(id);
    }



    }



