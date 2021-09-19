package ru.levelup.homework_number_four.task_number_one;

import ru.levelup.homework_number_three.task_number_one.aircraft.Airplane;

public class AirportException {

  Airplane non = new Airplane();

  public void createName(String name, Integer tonnage, Integer distance) {
    try {
      non.setName(name);
      non.setTonnage(tonnage);
      non.setDistance(distance);
    } catch (NullNameException | NegativeValueException | SizeValueException e) {
      System.err.println(e.getMessage());
    }
  }

}
