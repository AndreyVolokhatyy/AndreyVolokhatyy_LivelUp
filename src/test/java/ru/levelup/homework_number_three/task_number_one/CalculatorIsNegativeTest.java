package ru.levelup.homework_number_three.task_number_one;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorIsNegativeTest extends AbstractBaseCalculator{

  @Test
  @Description("Тест на число больше 0")
  public void isNegativeTrueTest(){
    boolean actual = calculator.isNegative(-10);
    boolean expected = true;
    Assert.assertEquals(actual, expected, "Incorrect result");
  }

  @Test
  @Description("Тест на синус")
  public void isNegativeFalseTest(){
    boolean actual = calculator.isNegative(10);
    boolean expected = false;
    Assert.assertEquals(actual, expected, "Incorrect result");
  }

}
