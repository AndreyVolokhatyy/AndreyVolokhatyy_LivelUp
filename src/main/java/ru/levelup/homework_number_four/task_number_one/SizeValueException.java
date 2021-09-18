package ru.levelup.homework_number_four.task_number_one;

public class SizeValueException extends RuntimeException {
  public SizeValueException() {
    super("Значение не соответсвует диапазону");
  }
}
