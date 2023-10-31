package com.example.demo.apicontroller;

import com.example.demo.model.Product;
import com.example.demo.model.ProductDto;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
  private final ProductService productService;

  @Autowired
  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping
  public List<Product> getAllProducts() {
    return productService.getAllProducts();
  }

  @GetMapping("/{productId}")
  public Product getProduct(@PathVariable int productId){
    Product product = productService.getProduct(productId);
    return product;
  }

  @PostMapping
  public String addProduct(@RequestBody Product product){
    String msg = productService.addProduct(product);
    return msg;
  }

  @PutMapping("/{productId}")
  public String updateProduct(@PathVariable int productId,
                              @RequestBody ProductDto productDto) {
    String msg = productService.updateProduct(productId, productDto);
    return msg;
  }

  @DeleteMapping("/{productId}")
  public String deleteProduct(@PathVariable int productId){
    return productService.deleteProduct(productId);
  }
}