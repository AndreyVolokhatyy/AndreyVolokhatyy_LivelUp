package ru.levelup.homework_number_three.task_number_one.aircraft;

import ru.levelup.homework_number_four.task_number_one.NegativeValueException;
import ru.levelup.homework_number_four.task_number_one.NullNameException;
import ru.levelup.homework_number_four.task_number_one.SizeValueException;

public class Aircraft {

  private String name;
  private Integer distance;
  private Integer tonnage;
  private Integer capacity;

  public Aircraft() {
  }

  public Aircraft(String name, Integer distance, Integer tonnage, Integer capacity) {
    this.name = name;
    this.distance = distance;
    this.tonnage = tonnage;
    this.capacity = capacity;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    if (name == "" || name == null) {
      throw new NullNameException();
    } else {
      this.name = name;
    }
  }

  public Integer getDistance() {
    return distance;
  }

  public void setDistance(Integer distance) {
    if (distance < 0) {
      throw new NegativeValueException();
    } else if (distance > 20000 || distance < 100) {
      throw new SizeValueException();
    } else {
      this.distance = distance;
    }
  }

  public Integer getTonnage() {
    return tonnage;
  }

  public void setTonnage(Integer tonnage) {
    if (tonnage < 0) {
      throw new NegativeValueException();
    } else if (tonnage > 200 || tonnage < 1) {
      throw new SizeValueException();
    } else {
      this.tonnage = tonnage;
    }
  }

  public Integer getCapacity() {
    return capacity;
  }

  public void setCapacity(Integer capacity) {
    if (capacity < 0) {
      throw new NegativeValueException();
    } else if (capacity > 400) {
      throw new SizeValueException();
    } else {
      this.capacity = capacity;
    }
  }

  @Override
  public String toString() {
    return "Aircraft: " + " Distance " + distance + " Tonnage " + tonnage + " Capacity " + capacity;
  }

  public void writeType() {
    System.out.println("Aircraft");
  }
}
