package com.pepcus.productmanagement.controller;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pepcus.productmanagement.model.Product;
import com.pepcus.productmanagement.service.ProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

  @Autowired
  private ProductService productService;

  @PostMapping("/")
  public Product addProduct(@Valid @RequestBody Product product) {
    return productService.addProduct(product);
  }

  @PatchMapping("/")
  public List<Product> updateCost(@RequestBody List<Product> products) {
    return productService.updateCost(products);
  }
  @GetMapping("/sortbyyear/")
  public List<Product> getAllProduct(){
    return productService.getAllLastYearProducts();
  }
  @GetMapping("/{id}")
  public List<Product> getAllProductBasedOnDepartmentid(@PathVariable int id){
    return productService.getAllProductBasedOnDepartmentid(id);
    
  }
}
