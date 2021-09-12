package ru.levelup.homework_number_four.task_number_one;

public class NullNameException extends RuntimeException {
  public NullNameException () {
    super("У транспортного средства нет наименования. Идентификация невозможна.");
  }
}
