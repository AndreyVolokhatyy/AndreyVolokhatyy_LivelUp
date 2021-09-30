import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import ru.levelup.homework_number_four.task_number_one.AirportException;
import ru.levelup.homework_number_four.task_number_two.GenerateNumber;
import ru.levelup.homework_number_three.task_number_one.airport.Airport;
import ru.levelup.homework_number_two.task_number_one.Calculator;

public class Main {

  public static void main(String[] args) throws IOException {
//    Calculator calc = new Calculator();
//    calc.calculate();
//
//    Airport airport = new Airport();
//    airport.totalParameters();
//    airport.writeParameterAircraft();
//    airport.sortDistance();
//    airport.search();
//    airport.readyFly();
//
//    AirportException exceptionWork = new AirportException();
//    exceptionWork.createName("", 10, 2000);
//    exceptionWork.createName("Быстролет", 0, 2000);
//    exceptionWork.createName("Быстролет", 10, -1);
//
//    GenerateNumber gen = new GenerateNumber();
//    List<Integer> list = gen.generateList();
//    System.out.println(list.size());
//    gen.uniqueValueTest(list);
//    gen.decomposition(list);

    List <String> list = new ArrayList<>();
    list.add("One_1");
    list.add("Two_1");
    list.add("Three_1");
    list.add("Two_1");
    list.add("Two_1");
    list.add("Two_1");
    list.add("One_1");
    list.add("Four_1");
    list.add("One_1");
    int z = 1;
    for (int i = 0; i < list.size(); i++) {
      for (int j = i+1; j < list.size(); j++) {
        if(list.get(i).equals(list.get(j))){
          z++;
          String zz = Integer.toString(z);
          list.set(j,list.get(j).replaceFirst("1",zz));
        }
      }
      System.out.println(list.get(i));
    }
  }
}
