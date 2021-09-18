package ru.levelup.homework_number_three.task_number_one.aircraft;

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
    this.name = name;
  }

  public Integer getDistance() {
    return distance;
  }

  public void setDistance(Integer distance) {
    this.distance = distance;
  }

  public Integer getTonnage() {
    return tonnage;
  }

  public void setTonnage(Integer tonnage) {
    this.tonnage = tonnage;
  }

  public Integer getCapacity() {
    return capacity;
  }

  public void setCapacity(Integer capacity) {
    this.capacity = capacity;
  }

  @Override
  public String toString() {
    return "Aircraft: " + " Distance " + distance + " Tonnage " + tonnage + " Capacity " + capacity;
  }

  public void writeType() {
    System.out.println("Aircraft");
  }
}
