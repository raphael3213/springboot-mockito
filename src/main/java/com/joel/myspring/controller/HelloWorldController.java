package com.joel.myspring.controller;

import com.joel.myspring.model.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

  @GetMapping("/hello-world")
  public String returnHelloWorld() {

    return "Hello World";
  }

  @GetMapping("/dummy-item")
  public Item returnItem() {
    return new Item(1, "Joel", 10, 100);
  }
}
