package com.ex.ecom_project.model;
import java.sql.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Component
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String Product_name;
  private String Discription;
  private Double Product_price;
  private boolean Product_Available;
  @JsonFormat(shape = Shape.STRING,pattern = "dd-MM-yyyy")
  private Date Product_uploaded_date;
  private int Product_Quantity;
  private String Product_brand;
  private String imageName;
  private String imageType;
  @Lob
  private byte[] imageData;
}