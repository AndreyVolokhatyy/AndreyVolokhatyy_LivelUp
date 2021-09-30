package ru.levelup.homework_number_six.task_number_one.registration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyData {

public String getData(String name) {
  FileInputStream fis;
  Properties property = new Properties();

    try {
        fis = new FileInputStream("src/test/resources/homework_number_seven/testdata.properties");
        property.load(fis);
        return property.getProperty(name);
      } catch (IOException e) {
        System.err.println("Файл свойств отсуствует!");
        return null;
    }
  }
}
