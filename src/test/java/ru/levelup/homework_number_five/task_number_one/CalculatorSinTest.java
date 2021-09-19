package ru.levelup.homework_number_five.task_number_one;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorSinTest extends AbstractBaseCalculator{

  @Test
  @Description("Тест на синус")
  public void sinTest(){
    double actual = calculator.sin(99);
    double expected = Math.sin(99);
    Assert.assertEquals(actual, expected, "Incorrect result");
  }

}
