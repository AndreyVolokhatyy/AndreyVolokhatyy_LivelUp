package ru.levelup.homework_number_four.task_number_one;

public class NegativeValueException extends RuntimeException {
  public NegativeValueException() {
    super("Введено отрицательное значение");
  }
}
