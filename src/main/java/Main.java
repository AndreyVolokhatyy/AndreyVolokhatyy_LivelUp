import ru.levelup.homework_number_three.task_number_one.airport.Airport;
import ru.levelup.homework_number_two.task_number_one.Calculator;

import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException {
//        Calculator calc = new Calculator();
//        calc.calculate();

    Airport airport = new Airport();
    airport.totalParameters();
    airport.writeParameterAircraft();
    airport.sortDistance();
    airport.search();
    airport.readyFly();
  }
}
