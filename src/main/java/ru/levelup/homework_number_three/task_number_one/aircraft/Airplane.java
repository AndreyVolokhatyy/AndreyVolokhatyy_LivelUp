package ru.levelup.homework_number_three.task_number_one.aircraft;

public class Airplane extends Aircraft implements Fly {

  private Integer maxHeight;

  public Integer getMaxHeight() {
    return maxHeight;
  }

  public void setMaxHeight(Integer maxHeight) {
    this.maxHeight =
        maxHeight;
  }

  @Override
  public void writeType() {
    System.out.println("Airplane");
  }

  @Override
  public void fly() {
    System.out.println("I Believe I Can Fly");
  }
}
