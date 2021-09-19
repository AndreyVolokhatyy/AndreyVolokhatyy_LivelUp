package ru.levelup.homework_number_three.task_number_one;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorCtgTest extends AbstractBaseCalculator{

  @Test
  @Description("Тест на котангенс")
  // Котангенс = cos / sin. В калькуляторе ошибка
  public void ctgTest(){
    double actual = calculator.ctg(30);
    double expected = Math.cos(30) / Math.sin(30);
    Assert.assertEquals(actual, expected, "Incorrect result");
  }

}
