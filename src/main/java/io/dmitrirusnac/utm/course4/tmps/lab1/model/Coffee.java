package io.dmitrirusnac.utm.course4.tmps.lab1.model;

public class Coffee implements Drink{

  @Override
  public void prepare() {
    System.out.println("Preparing coffee: boiling beans, adding water.");
  }
}
