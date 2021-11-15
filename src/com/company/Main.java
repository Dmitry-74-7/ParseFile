package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
  // Получить коллекцию пользователей
  // Вывести на экран столбиком пользователей (формат не важен)
  // Сделать возраст опциональным
  // Остортировать список пользователей по возрасту, по убыванию, без возраста вначале списка

  public static void main(String[] args) throws IOException {
    List<String> lines = Files.readAllLines(Paths.get("src\\com\\company\\resources\\users.txt"));

    if (lines.size() % 3 != 0) {
      System.out.println("Неверный формат, пропущена строка");
      return;
    }

    List<User> users = new ArrayList<>();
    for (int i = 0; i < lines.size(); i = i + 3) {
      users.add(new User(
          //фамилия
          lines.get(i + 1),
          //Имя
          lines.get(i),
          //Возраст
          getAge(lines.get(i + 2))));
    }

    System.out.println("Вывод пользователей");
    print(users);

    System.out.println("Вывод пользователей по возрасту");
    users.sort((o1, o2) -> getAge(o2.getAge()) - getAge(o1.getAge()));
    print(users);
  }

  private static Integer getAge(String age) {
    if (age == null || age.equals("") || !age.matches("\\d+")) {
      return null;
    }
    return Integer.parseInt(age);
  }

  private static Integer getAge(Integer age) {
    if (age == null) {
      return Integer.MAX_VALUE;
    }
    return age;
  }


  private static void print(List<User> users) {
    for (User user : users) {
      System.out.println(user);
    }
  }


}
