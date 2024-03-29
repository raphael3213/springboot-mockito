package com.joel.myspring.unittesting;

import com.joel.myspring.data.SomeDataService;
import com.joel.myspring.service.SomeBusinessImpl;
// import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockTest {

  List mockList = mock(List.class);

  @Test
  public void size_basic() {
    when(mockList.size()).thenReturn(5).thenReturn(10);

    assertEquals(mockList.size(), 5);
    assertEquals(mockList.size(), 10);
  }

  @Test
  public void returnWithParameters() {
    when(mockList.get(0)).thenReturn(5);

    assertEquals(mockList.get(0), 5);
    assertEquals(mockList.size(), 0);
  }

  @Test
  public void returnWithAnyParameters() {
    when(mockList.get(anyInt())).thenReturn(5);

    assertEquals(mockList.get(0), 5);
  }

  @Test
  public void verify_basics() {
    Object value = mockList.get(0);

    verify(mockList, atLeast(0)).get(0);
    verify(mockList, never()).get(5);
    verify(mockList, times(1)).get(0);
    verify(mockList).get(0);
  }

  @Test
  public void verify_argumentCaptured() {

    Object value = mockList.get(0);
    ArgumentCaptor<Integer> captor = ArgumentCaptor.forClass(Integer.class);
    verify(mockList).get(captor.capture());

    assertEquals(0, captor.getValue());
  }

  @Test
  public void verify_multipleArgumentCaptured() {

    Object value1 = mockList.get(0);
    Object value2 = mockList.get(1);
    ArgumentCaptor<Integer> captor = ArgumentCaptor.forClass(Integer.class);
    verify(mockList, times(2)).get(captor.capture());

    assertEquals(0, captor.getAllValues().get(0));
    assertEquals(1, captor.getAllValues().get(1));
  }

  @Test
  public void verify_spying() {

    // spying is the same as mocking, with the only difference that spying
    // uses the real Class and not a mock,
    // which does not have any of the behavior of an original object of the class being mocked
    // You can use verify with a spy object
    ArrayList arrayListSpy = spy(new ArrayList());
    arrayListSpy.add("Helki");

    verify(arrayListSpy).add("Helki");
  }
}
