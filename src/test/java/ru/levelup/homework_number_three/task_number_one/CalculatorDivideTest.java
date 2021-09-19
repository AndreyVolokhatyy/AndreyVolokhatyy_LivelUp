package ru.levelup.homework_number_three.task_number_one;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorDivideTest extends AbstractBaseCalculator{

  @Test
  @Description("Тест на деление")
  public void divideTest(){
    long actual = calculator.div(30,6);
    long expected = 30 / 6;
    Assert.assertEquals(actual, expected, "Incorrect result");
  }

  @Test(expectedExceptions = NumberFormatException.class,
      expectedExceptionsMessageRegExp = "Attempt to divide by zero")
  @Description("Тест деления на 0")
  public void divideZeroTest(){
    calculator.div(30,0);
  }

}
