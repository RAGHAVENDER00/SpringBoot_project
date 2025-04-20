package com.ex.ecom_project.service;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.ex.ecom_project.model.Product;
import com.ex.ecom_project.repositary.repo;

@Service
public class ProductService {

  @Autowired
  repo re;

  @Autowired
  Product Product;

  public List<Product> productListing() {
    return re.findAll();
       
  }

  public void adding_porduct(Product pro, MultipartFile image) throws IOException {
    Product.setImageName(image.getOriginalFilename());
    Product.setImageType(image.getContentType());
    Product.setImageData(image.getBytes());
    re.save(pro);
    
  }

  public void upadating_product(Product prodId) {
    
    re.save(prodId);
    
  }

  public Product getting_prodcut(int prodId) {

    return re.findById(prodId).orElse(new Product());
  }

  public List<Product> productsearching(String keyword) {
    return re.searchProducts(keyword);
  }



}
