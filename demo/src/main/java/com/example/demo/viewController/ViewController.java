package com.example.demo.viewController;

import com.example.demo.model.Product;
import com.example.demo.model.Student;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/view")
public class ViewController {
  private final ProductService productService;

  @Autowired
  public ViewController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping("/products")
  public String method0(Model model){
    List<Product> allProducts = productService.getAllProducts();
    model.addAttribute("products", allProducts);
    return "productList";
  }

  @GetMapping("/text")
  public String method1(Model model) {
    model.addAttribute("data", "Hello, world!");
    return "text";
  }

  @GetMapping("/object")
  public String method2(Model model){
    Student student = new Student();
    student.setName("testName");
    model.addAttribute("student", student);
    return "obj";
  }

  @GetMapping("/param")
  public String method4(@RequestParam Integer param1,
                        @RequestParam Integer param2,
                        Model model){
    model.addAttribute("result", param1 + param2);
    return "param";
  }

  @GetMapping("/param/{param1}/{param2}")
  public String method5(@PathVariable Integer param1,
                        @PathVariable Integer param2,
                        Model model){
    model.addAttribute("result", param1 + param2);
    return "param";
  }

  @GetMapping("/param/{param1}")
  public String method6(@PathVariable Integer param1,
                        @RequestParam Integer param2,
                        Model model){
    model.addAttribute("result", param1 + param2);
    return "param";
  }

  @GetMapping("/link")
  public String method3(Model model){
    model.addAttribute("param1", 3);
    model.addAttribute("param2", 5);
    return "link";
  }

  @GetMapping("/student")
  public String method7(){
    return "studentForm";
  }

  @PostMapping("/student")
  @ResponseBody
  public Student method8(@ModelAttribute Student student){
    return student;
  }
}