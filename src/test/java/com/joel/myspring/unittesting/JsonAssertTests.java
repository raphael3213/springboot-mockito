package com.joel.myspring.unittesting;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTests {

  String myJsonString = "{\"id\": 1,  \"price\": 10,\"quantity\": 100,  \"name\": \"Joel\" }";

  @Test
  public void jsonAssert_StrictTrue_ExactStructureMatchExceptForSpaces() throws JSONException {

    // All json fields must be present and be equal

    String expectedJson = "{\"id\": 1,  \"quantity\": 100, \"price\": 10, \"name\": \"Joel\" }";
    JSONAssert.assertEquals(expectedJson, myJsonString, true);
  }

  @Test
  public void jsonAssert_StrictFalse_ExactStructureMatchExceptForSpaces() throws JSONException {

    // All json fields need not be present, but the ones that are present, need to be equal

    String expectedJson = "{\"id\": 1,  \"quantity\": 100, \"name\": \"Joel\" }";
    JSONAssert.assertEquals(expectedJson, myJsonString, false);
  }

  @Test
  public void jsonAssert_StrictFalse_WithoutEscapeCharacters() throws JSONException {

    // When false, escape characters need not be present

    String expectedJson = "{id: 1,  quantity: 100, name: Joel }";
    JSONAssert.assertEquals(expectedJson, myJsonString, false);
  }
}
