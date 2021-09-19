package ru.levelup.homework_number_three.task_number_one;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorSubTest extends AbstractBaseCalculator{

  @Test
  @Description("Тест на вычитание")
  public void subTest(){
    long actual = calculator.sub(99,98);
    long expected = 99 - 98;
    Assert.assertEquals(actual, expected, "Incorrect result");
  }

}
