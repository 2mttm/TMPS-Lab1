package io.dmitrirusnac.utm.course4.tmps.lab1.logger;

import java.util.ArrayList;
import java.util.List;

public class OrderLogger {
  private static OrderLogger instance;
  private final List<String> orders = new ArrayList<>();

  private OrderLogger() {}

  public static OrderLogger getInstance() {
    if (instance == null) {
      instance = new OrderLogger();
    }
    return instance;
  }

  public void log(String order) {
    orders.add(order);
  }

  public void printOrders() {
    orders.forEach(System.out::println);
  }
}
