package ru.levelup.homework_number_three.task_number_one;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorSumTest extends AbstractBaseCalculator{

  @Test
  @Description("Тест на сложение")
  public void sumTest(){
    long actual = calculator.sub(35,9);
    long expected = 35 + 9;
    Assert.assertEquals(actual, expected, "Incorrect result");
  }

}
