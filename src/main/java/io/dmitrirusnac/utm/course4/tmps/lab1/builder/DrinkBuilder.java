package io.dmitrirusnac.utm.course4.tmps.lab1.builder;

import io.dmitrirusnac.utm.course4.tmps.lab1.model.CustomDrink;
import io.dmitrirusnac.utm.course4.tmps.lab1.model.DrinkType;

public class DrinkBuilder {
    private DrinkType baseType;
    private int iceAmountGrams = 0;
    private int sugarAmountGrams = 0;
    private int milkAmountMilliliters = 0;

    public DrinkBuilder setBaseType(DrinkType baseType) {
        this.baseType = baseType;
        return this;
    }

    public DrinkBuilder withIce(int amount) {
        this.iceAmountGrams = amount;
        return this;
    }

    public DrinkBuilder withSugar(int amount) {
        this.sugarAmountGrams = amount;
        return this;
    }

    public DrinkBuilder withMilk(int amount) {
        this.milkAmountMilliliters = amount;
        return this;
    }

    public CustomDrink build() {
        return new CustomDrink(baseType, sugarAmountGrams, milkAmountMilliliters, iceAmountGrams);
    }
}
