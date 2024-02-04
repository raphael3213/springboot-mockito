package com.joel.myspring.unittesting.service;

import com.joel.myspring.data.ItemRepository;
import com.joel.myspring.model.Item;
import com.joel.myspring.service.ItemBusinessService;
import org.assertj.core.util.Arrays;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ItemBusinessServiceTest {

  @InjectMocks private ItemBusinessService itemBusinessService;

  @Mock private ItemRepository itemRepository;

  @Test
  public void retreiveAllItems_checkValueCalculation() {
    when(itemRepository.findAll()).thenReturn(Lists.newArrayList(new Item(10001, "Joel", 10, 100)));
    List<Item> items = itemBusinessService.retreiveAllItems();
    Item firstItem = items.get(0);

    assertEquals(firstItem.getValue(), 10 * 100);
  }
}
