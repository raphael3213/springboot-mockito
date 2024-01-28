package com.joel.myspring.unittesting.business;

import com.joel.myspring.data.SomeDataService;
import com.joel.myspring.service.SomeBusinessImpl;
// import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SomeBusinessTest {

  @InjectMocks static SomeBusinessImpl someBusiness = new SomeBusinessImpl();
  @Mock static SomeDataService dataServiceMock;

  @BeforeAll
  public static void before() {

    someBusiness.setSomeDataService(dataServiceMock);
  }

  @Test
  public void calculateSum_basic() {

    when(dataServiceMock.retreiveAllData()).thenReturn(new int[] {1, 2, 3});
    assertEquals(someBusiness.calculateSum(), 6);
  }

  @Test
  public void calculateSum_empty() {
    when(dataServiceMock.retreiveAllData()).thenReturn(new int[] {});
    assertEquals(someBusiness.calculateSum(), 0);
  }

  @Test
  public void calculateSum_oneValue() {
    when(dataServiceMock.retreiveAllData()).thenReturn(new int[] {1});
    assertEquals(someBusiness.calculateSum(), 1);
  }
}
