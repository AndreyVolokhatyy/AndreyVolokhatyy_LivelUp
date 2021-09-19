package ru.levelup.homework_number_three.task_number_one;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorMultiplyTest  extends AbstractBaseCalculator {

  @Test(dataProviderClass = CalculatorDataProvider.class,
      dataProvider = "multiplyPositiveDataProvider")
  @Description("Позитивный тест на умножение")
  public void multiplyPositiveTest(long a, long b, long expectedSum) {
    long actualSum = calculator.mult(a, b);
    Assert.assertEquals(actualSum, expectedSum, "Incorrect result");
  }

  @Test(dataProviderClass = CalculatorDataProvider.class,
      dataProvider = "multiplyNegativeDataProvider")
  @Description("Негативный тест на умножение")
  public void multiplyNegativeTest(long a, long b, long expectedSum) {
    long actualSum = calculator.mult(a, b);
    Assert.assertNotEquals(actualSum, expectedSum, "Incorrect result");
  }
}
