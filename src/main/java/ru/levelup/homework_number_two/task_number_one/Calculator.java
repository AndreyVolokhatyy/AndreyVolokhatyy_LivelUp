package ru.levelup.homework_number_two.task_number_one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {
    public double a,b;
    int math;

    public void calculate() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите число А");
        this.a = Double.parseDouble(reader.readLine());

        System.out.println("Введите номер арифметического действия:\n"
                + "1 - Сложение\n"
                + "2 - Вычитание\n"
                + "3 - Умножение\n"
                + "4 - Деление"
        );
        this.math = Integer.parseInt(reader.readLine());

        System.out.println("Введите число B");
        this.b = Double.parseDouble(reader.readLine());

        if (b == 0 && math == 4){
            System.out.println("Error: divide by zero");
        } else if (math == 1){
            System.out.println("Результат: "+ (a+b));
        } else if (math == 2){
            System.out.println("Результат: "+ (a-b));
        } else if (math == 3){
            System.out.println("Результат: "+ (a*b));
        } else if (math == 4){
            System.out.println("Результат: "+ (a/b));
        } else if (math < 1 || math > 4){
            System.out.println("Данного арифметического действия нет в списке");
        }
    }

}
