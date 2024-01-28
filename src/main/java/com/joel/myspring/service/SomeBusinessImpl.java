package com.joel.myspring.service;

import com.joel.myspring.data.SomeDataService;

import java.util.Arrays;

public class SomeBusinessImpl {

  private SomeDataService someDataService;

  public void setSomeDataService(SomeDataService someDataService) {
    this.someDataService = someDataService;
  }

  public int calculateSum() {

    return Arrays.stream(someDataService.retreiveAllData()).sum();
  }
}
