package ru.levelup.homework_number_five.task_number_one;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorCosTest extends AbstractBaseCalculator{

  @Test
  @Description("Тест на косинус")
  //Ошибка в калькуляторе
  public void cosTest(){
    double actual = calculator.cos(20);
    double expected = Math.cos(20);
    Assert.assertEquals(actual, expected, "Incorrect result");
  }

}
