package ru.levelup.homework_number_eight;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;
import ru.levelup.homework_number_six.task_number_one.registration.PropertyData;

public class RestApi {
  PropertyData testData = new PropertyData();

  @BeforeMethod
  public void setUp() {
    RestAssured.baseURI = testData.getData("base.uri");
  }

}
