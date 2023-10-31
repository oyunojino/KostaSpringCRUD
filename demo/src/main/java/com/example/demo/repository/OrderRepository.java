package com.example.demo.repository;

public interface OrderRepository {
  int getPrice(int price); // 1) 10000 ==> 9900원 2) 10000원 ==> 9000원
}
