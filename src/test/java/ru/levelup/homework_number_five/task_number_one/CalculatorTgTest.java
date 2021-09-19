package ru.levelup.homework_number_five.task_number_one;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTgTest extends AbstractBaseCalculator{

  @Test
  @Description("Тест на тангенс")
  public void tgTest(){
    double actual = calculator.tg(50);
    double expected = Math.tanh(50);
    Assert.assertEquals(actual, expected, "Incorrect result");
  }

}
