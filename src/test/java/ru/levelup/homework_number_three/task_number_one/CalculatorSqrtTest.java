package ru.levelup.homework_number_three.task_number_one;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorSqrtTest extends AbstractBaseCalculator{

  @Test
  @Description("Тест на квадратный корень")
  public void sqrtTest(){
    double actual = calculator.sqrt(25);
    double expected = Math.sqrt(25);
    Assert.assertEquals(actual, expected, "Incorrect result");
  }

}
