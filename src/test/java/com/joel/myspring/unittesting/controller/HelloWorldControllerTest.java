package com.joel.myspring.unittesting.controller;

import com.joel.myspring.controller.HelloWorldController;
import com.joel.myspring.model.Item;
import com.joel.myspring.service.ItemBusinessService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// This ensures that only this Controller is up and running for testing
@WebMvcTest(value = HelloWorldController.class)
public class HelloWorldControllerTest {
  @Autowired private MockMvc mockMvc; // bean exists when we run WebMvcTest

  @MockBean private ItemBusinessService businessService;

  @Test
  public void testHelloWorld() throws Exception {
    RequestBuilder request =
        MockMvcRequestBuilders.get("/hello-world").accept(MediaType.APPLICATION_JSON);

    MvcResult result =
        this.mockMvc
            .perform(request)
            .andExpect(status().isOk())
            .andExpect(content().string("Hello World"))
            .andReturn();

    //    assertEquals("Hello World", result.getResponse().getContentAsString());
  }

  @Test
  public void dummyItem_basic() throws Exception {
    RequestBuilder request =
        MockMvcRequestBuilders.get("/dummy-item").accept(MediaType.APPLICATION_JSON);

    MvcResult result =
        this.mockMvc
            .perform(request)
            .andExpect(status().isOk())
            .andExpect(
                content()
                    .json("{\"id\": 1,  \"price\": 10,\"quantity\": 100,  \"name\": \"Joel\" }"))
            .andReturn();

    //    assertEquals("Hello World", result.getResponse().getContentAsString());
  }

  @Test
  public void returnItemFromBusinessService_basic() throws Exception {

    when(businessService.retreiveHardcodedItem()).thenReturn(new Item(1, "Joel", 10, 100));
    RequestBuilder request =
        MockMvcRequestBuilders.get("/item-from-business-service")
            .accept(MediaType.APPLICATION_JSON);

    MvcResult result =
        this.mockMvc
            .perform(request)
            .andExpect(status().isOk())
            .andExpect(
                content()
                    .json("{\"id\": 1,  \"price\": 10,\"quantity\": 100,  \"name\": \"Joel\" }"))
            .andReturn();
  }
}
