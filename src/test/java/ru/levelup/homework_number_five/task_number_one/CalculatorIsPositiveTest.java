package ru.levelup.homework_number_five.task_number_one;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorIsPositiveTest extends AbstractBaseCalculator{

  @Test
  @Description("Тест на число больше 0")
  public void isPositiveTrueTest(){
    boolean actual = calculator.isPositive(99);
    boolean expected = true;
    Assert.assertEquals(actual, expected, "Incorrect result");
  }

  @Test
  @Description("Тест на синус")
  public void isPositiveFalseTest(){
    boolean actual = calculator.isPositive(0);
    boolean expected = false;
    Assert.assertEquals(actual, expected, "Incorrect result");
  }

}
