package com.joel.myspring.model;

public class Item {

  private int id;
  private int price;
  private int quantity;
  private String name;

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
