package com.pepcus.productmanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pepcus.productmanagement.exception.CustomException;
import com.pepcus.productmanagement.model.Product;
import com.pepcus.productmanagement.repository.DepartmentRepository;
import com.pepcus.productmanagement.repository.ProductRepository;

@Service
public class ProductService {
   @Autowired
   private ProductRepository productRepository;
   
   @Autowired
   private DepartmentRepository departmentRepository;
   
  public Product addProduct(Product product) {
    if(!departmentRepository.existsById(product.getDepartmentId())) {
      throw new CustomException("invalid Department Id");
    }
    return productRepository.save(product);
  }

  public List<Product> updateCost(List<Product> products) {
    List<Product> updatedProducts = new ArrayList<Product>();
    
    for(Product product : products) {
      if(!productRepository.existsById(product.getId())) {
        throw new CustomException("Invalid product id: " + product.getId());
      }
      Optional<Product> p = productRepository.findById(product.getId());
      Product realProduct = p.get();
      product.setName(realProduct.getName());
      product.setDate(realProduct.getDate());
      product.setDepartmentId(realProduct.getDepartmentId());
      productRepository.save(product);
      updatedProducts.add(product);
    } 
    return updatedProducts;
  }

  public List<Product> getAllLastYearProducts() {
     
    return productRepository.getAllProduct();
  }

  public List<Product> getAllProductBasedOnDepartmentid(int id) {
    
    return productRepository.getAllProductBasedOnDepartmentid(id);
  }

}
