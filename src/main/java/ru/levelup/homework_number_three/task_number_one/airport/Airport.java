package ru.levelup.homework_number_three.task_number_one.airport;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import ru.levelup.homework_number_three.task_number_one.aircraft.Airplane;
import ru.levelup.homework_number_three.task_number_one.aircraft.Helicopter;

public class Airport {

  Helicopter apache = new Helicopter();
  Helicopter mi = new Helicopter();
  Airplane boing = new Airplane();
  Airplane tu = new Airplane();

  public Airport() {
    apache.setName("APACHE");
    apache.setWeapon("Gathling");
    apache.setDistance(500);
    apache.setTonnage(5);
    apache.setCapacity(2);

    mi.setName("MI");
    mi.setWeapon("non");
    mi.setDistance(700);
    mi.setTonnage(10);
    mi.setCapacity(18);

    boing.setName("BOING");
    boing.setMaxHeight(12000);
    boing.setDistance(10000);
    boing.setTonnage(15);
    boing.setCapacity(200);

    tu.setName("TU");
    tu.setMaxHeight(10000);
    tu.setDistance(15000);
    tu.setTonnage(20);
    tu.setCapacity(180);
  }

  public void totalParameters() {
    System.out.println("Средняя дальность полета транспортных средст аэропорта (км): "
        + (apache.getDistance() + mi.getDistance() + boing.getDistance() + tu.getDistance()) / 4);
    System.out.println(
        "Сумма грузоподъемности транспортных средст аэропорта (т): " + apache.getTonnage()
            + mi.getTonnage() + boing.getTonnage() + tu.getTonnage());
    System.out.println("Вместимость транспортных средст аэропорта (чел): " + apache.getCapacity()
        + mi.getCapacity() + boing.getCapacity() + tu.getCapacity());
  }

  public void writeParameterAircraft() {
    apache.writeType();
    System.out.println("Вооружение " + apache.getWeapon()
        + " Дальность полета " + apache.getDistance()
        + " Грузоподъемность " + apache.getTonnage()
        + " Вместимость " + apache.getCapacity());
  }

  public void sortDistance() {
    HashMap<String, Integer> sort = new HashMap();
    sort.put(apache.getName(), apache.getDistance());
    sort.put(mi.getName(), mi.getDistance());
    sort.put(boing.getName(), boing.getDistance());
    sort.put(tu.getName(), tu.getDistance());

    sort.entrySet().stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .forEach(System.out::println);
  }

  public void search() throws IOException {
    System.out.println("Введите диапазон грузоподъемности:");
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int minT = Integer.parseInt(reader.readLine());
    Integer maxT = Integer.parseInt(reader.readLine());
    System.out.println("Введите диапазон вместимости");
    int minC = Integer.parseInt(reader.readLine());
    Integer maxC = Integer.parseInt(reader.readLine());
    if (minT <= apache.getTonnage() && apache.getTonnage() <= maxT && minC <= apache.getCapacity()
        && apache.getCapacity() <= maxC) {
      System.out.println(
          apache.getName() + " Грузоподъемность: " + apache.getTonnage() + " Вместимость: "
              + apache.getCapacity());
    }
    if (minT <= mi.getTonnage() && mi.getTonnage() <= maxT && minC <= mi.getCapacity()
        && mi.getCapacity() <= maxC) {
      System.out.println(mi.getName() + " Грузоподъемность: " + mi.getTonnage() + " Вместимость: "
          + mi.getCapacity());
    }
    if (minT <= boing.getTonnage() && boing.getTonnage() <= maxT && minC <= boing.getCapacity()
        && boing.getCapacity() <= maxC) {
      System.out.println(
          boing.getName() + " Грузоподъемность: " + boing.getTonnage() + " Вместимость: "
              + boing.getCapacity());
    }
    if (minT <= tu.getTonnage() && tu.getTonnage() <= maxT && minC <= tu.getCapacity()
        && tu.getCapacity() <= maxC) {
      System.out.println(tu.getName() + " Грузоподъемность: " + tu.getTonnage() + " Вместимость: "
          + tu.getCapacity());
    }
  }

  public void readyFly() {
    boing.fly();
  }

}
