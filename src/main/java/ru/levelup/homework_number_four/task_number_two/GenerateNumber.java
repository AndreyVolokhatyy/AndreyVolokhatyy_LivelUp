package ru.levelup.homework_number_four.task_number_two;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateNumber {

  public List generateList (){
   List <Integer> created = new ArrayList<>();
    for (int i = 1; i < 100001; i++){
      created.add(i);
    }
    Collections.shuffle(created);
    return created;
  }
  public void uniqueValueTest(List created){
    Set<Integer> uniqueValue = new HashSet<Integer>(created);
    if(uniqueValue.size() == created.size()){
      System.out.println("Все значения уникальны");
    } else {
      System.out.println("Значения не уникальны");
    }
  }

  public void decomposition(List created) throws IOException {
    List<Integer> list2 = new ArrayList<>();
    List<Integer> list3 = new ArrayList<>();
    List<Integer> list5 = new ArrayList<>();
    List<Integer> list7 = new ArrayList<>();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int a = Integer.parseInt(reader.readLine());
    if (a == 2 || a == 3 || a == 5 || a == 7) {
      for (int i = 0; i < created.size(); i++) {
        int num = (int) created.get(i);
        if (num % 2 == 0) {
          list2.add(num);
        } else if (num % 3 == 0) {
          list3.add(num);
        } else if (num % 5 == 0) {
          list5.add(num);
        } else if (num % 7 == 0) {
          list7.add(num);
        }
      }
        switch (a) {
          case 2:
            System.out.println(list2);
            break;
          case 3:
            System.out.println(list3);
            break;
          case 5:
            System.out.println(list5);
            break;
          case 7:
            System.out.println(list7);
            break;
        }
      } else {
        System.out.println("Введенное число вне диапазона (2, 3, 5, 7)");
    }
  }
}
