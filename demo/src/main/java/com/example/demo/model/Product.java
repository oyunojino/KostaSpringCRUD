package com.example.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder // builder, build를 가져와서 함수처럼 사용 가능
public class Product {
  private int productId;
  private String productName;
  private String maker;
  private int price;
  private int qty;
}
