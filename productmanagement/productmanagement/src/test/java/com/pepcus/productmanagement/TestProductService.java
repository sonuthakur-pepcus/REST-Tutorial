 package com.pepcus.productmanagement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.pepcus.productmanagement.controller.ProductController;
import com.pepcus.productmanagement.model.Product;
import com.pepcus.productmanagement.repository.ProductRepository;
import com.pepcus.productmanagement.service.ProductService;

@RunWith(MockitoJUnitRunner.class)
public class TestProductService {

  @InjectMocks
  private ProductService productService;
  
  private ProductController productController;
  @Mock
  private ProductRepository productRepository;
  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }
  @Test
  public void testAddProduct() { 
    Product product=new Product();
    Date d=new Date();
    product.setId(1);
    product.setName("shirt"); 
    product.setCost(550);
    product.setDate(d);
    product.setDepartmentId(3);
    
    Mockito.when(productRepository.save(product)).thenReturn(product);
    assertThat(productRepository.save(product)).isEqualTo(product);
  }
 @Test
  public void getProductByDepartmentId() {
    Date d=new Date();
    Product product=new Product(1,"shirt",550,d,3);
    List<Product> productList=new ArrayList();
    productList.add(product);
 
   List<Product> rs=productController.getAllProductBasedOnDepartmentid(3);
    Mockito.when(productService.getAllProductBasedOnDepartmentid(3)).thenReturn(rs);
   Assert.assertNotNull(rs);

  }
}
