package com.joel.myspring.controller;

import com.joel.myspring.model.Item;
import com.joel.myspring.service.ItemBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

  @Autowired ItemBusinessService businessService;

  @GetMapping("/hello-world")
  public String returnHelloWorld() {

    return "Hello World";
  }

  @GetMapping("/dummy-item")
  public Item returnItem() {
    return new Item(1, "Joel", 10, 100);
  }

  @GetMapping("/item-from-business-service")
  public Item returnItemFromBusinessService() {
    return businessService.retreiveHardcodedItem(); // new Item(1, "Joel", 10, 100);
  }
}
