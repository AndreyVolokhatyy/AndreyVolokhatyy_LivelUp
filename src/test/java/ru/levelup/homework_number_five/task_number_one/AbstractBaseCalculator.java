package ru.levelup.homework_number_five.task_number_one;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.levelup.qa.at.calculator.Calculator;

public abstract class AbstractBaseCalculator {

  protected Calculator calculator;

  @BeforeMethod
  public void beforeTestClass() {
    calculator = new Calculator();
  }

  @AfterMethod
  public void beforeTestMethod() {
    calculator = null;
  }

}
