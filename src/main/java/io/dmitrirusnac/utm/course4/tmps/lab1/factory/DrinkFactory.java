package io.dmitrirusnac.utm.course4.tmps.lab1.factory;

import io.dmitrirusnac.utm.course4.tmps.lab1.model.*;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DrinkFactory {
    private static final Map<DrinkType, Supplier<Drink>> drinkRegistry = new HashMap<>();

    static {
        drinkRegistry.put(DrinkType.COFFEE, Coffee::new);
        drinkRegistry.put(DrinkType.TEA, Tea::new);
        drinkRegistry.put(DrinkType.JUICE, Juice::new);
    }

    public static Drink createDrink(DrinkType type) {
        Supplier<Drink> supplier = drinkRegistry.get(type);
        if (supplier != null) {
            return supplier.get();
        }
        throw new IllegalArgumentException("Unknown drink type: " + type);
    }
}
