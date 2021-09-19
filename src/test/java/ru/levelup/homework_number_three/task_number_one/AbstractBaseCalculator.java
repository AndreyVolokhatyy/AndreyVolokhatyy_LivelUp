package ru.levelup.homework_number_three.task_number_one;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import ru.levelup.qa.at.calculator.Calculator;

public abstract class AbstractBaseCalculator {

  protected Calculator calculator;

  @BeforeTest
  public void beforeTestClass() {
    calculator = new Calculator();
  }

  @AfterTest
  public void beforeTestMethod() {
    calculator = null;
  }

}
