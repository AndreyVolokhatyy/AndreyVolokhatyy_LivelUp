package ru.levelup.homework_number_three.task_number_one;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorPowTest extends AbstractBaseCalculator{

  @Test
  @Description("Тест на возведение в степень")
  public void powTest(){
    double actual = calculator.pow(2,3);
    double expected = Math.pow(2,3);
    Assert.assertEquals(actual, expected, "Incorrect result");
  }

}
