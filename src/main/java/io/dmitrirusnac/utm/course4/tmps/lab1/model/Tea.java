package io.dmitrirusnac.utm.course4.tmps.lab1.model;

public class Tea implements Drink {

    @Override
    public void prepare() {
        System.out.println("Preparing tea: boiling the pack in hot water.");
    }
}
