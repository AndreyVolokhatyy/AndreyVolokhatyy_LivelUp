package ru.levelup.homework_number_three.task_number_one.aircraft;

public class Helicopter extends Aircraft {

  private String weapon;

  public String getWeapon() {
    return weapon;
  }

  public void setWeapon(String weapon) {
    this.weapon =
        weapon;
  }

  @Override
  public void writeType() {
    System.out.println("Helicopter");
  }
}
