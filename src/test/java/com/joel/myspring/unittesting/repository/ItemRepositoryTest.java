package com.joel.myspring.unittesting.repository;

import com.joel.myspring.data.ItemRepository;
import com.joel.myspring.model.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class ItemRepositoryTest {
  // This is testing for JPA class.

  @Autowired ItemRepository itemRepository;

  @Test
  public void testFindAll() {
    List<Item> items = itemRepository.findAll();
    assertEquals(items.size(), 3);
  }
}
