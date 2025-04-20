package com.ex.ecom_project.controller;

import java.io.IOException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ex.ecom_project.model.Product;
import com.ex.ecom_project.service.ProductService;

@RestController

public class ProductController {

  @Autowired
  ProductService producr_service;



  @GetMapping("/product")
  public List<Product> product_list(){
    
    return producr_service.productListing();  
  }

  @PutMapping("/product")
  public void upadate_product(Product ProdId){
    producr_service.upadating_product(ProdId);
  }

  @GetMapping("/product/{id}")
  public Product getproduct(@PathVariable int id){
    return producr_service.getting_prodcut(id);
  }

  @PostMapping("/product")
  public ResponseEntity<?> add_Product(@RequestPart Product pro,@RequestPart MultipartFile image) throws IOException{
    producr_service.adding_porduct(pro,image); 
    return null;
  } 

  @GetMapping("/product/search")
  public List<Product> search_Product(@RequestParam String keyword){

    return producr_service.productsearching(keyword);
  } 


}
