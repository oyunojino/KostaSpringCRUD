package com.example.demo;

import com.example.demo.service.AmountOrderService;
import com.example.demo.service.OrderService;
import com.example.demo.service.RateOrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
  @Bean
  public OrderService orderService(){
    //return new AmountOrderService();
    return new RateOrderService();
  }
}