package ru.levelup.homework_number_five.task_number_one;

import org.testng.annotations.DataProvider;

public class CalculatorDataProvider {

  @DataProvider
  public Object[][] multiplyPositiveDataProvider() {
    return new Object[][] {
        {7, 7, 49},
        {20, 20, 400},
        {3, 3, 9}
    };
  }

  @DataProvider
  public Object[][] multiplyNegativeDataProvider() {
    return new Object[][] {
        {5, 5, 5},
        {4, 4, -10},
        {3, 3, 0}
    };
  }

}
