package io.dmitrirusnac.utm.course4.tmps.lab1.model;

public class Juice implements Drink {

    @Override
    public void prepare() {
        System.out.println("Preparing juice: getting some cold juice from a pack.");
    }
}
