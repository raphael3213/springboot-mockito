package com.joel.myspring.service;

import com.joel.myspring.data.ItemRepository;
import com.joel.myspring.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemBusinessService {

  @Autowired ItemRepository itemRepository;

  public Item retreiveHardcodedItem() {
    return new Item(1, "Joel", 10, 100);
  }

  public List<Item> retreiveAllItems() {
    return itemRepository.findAll();
  }
}
