package com.joel.myspring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class Item {
  @Id private int id;
  private String name;
  private int price;
  private int quantity;

  public int getValue() {
    return value;
  }

  @Transient private int value;

  public int getId() {
    return id;
  }

  public int getPrice() {
    return price;
  }

  public int getQuantity() {
    return quantity;
  }

  public String getName() {
    return name;
  }

  public Item(int id, String name, int price, int quantity) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.quantity = quantity;
  }

  public String toString() {
    return String.format("Item [%d %s %d %d]", id, name, price, quantity);
  }
}
