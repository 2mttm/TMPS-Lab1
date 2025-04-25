package io.dmitrirusnac.utm.course4.tmps.lab1.model;

public class CustomDrink implements Drink {
  private final DrinkType baseType;
  private final int iceAmountGrams;
  private final int sugarAmountGrams;
  private final int milkAmountMilliliters;

  public CustomDrink(
      DrinkType baseType, int iceAmountGrams, int sugarAmountGrams, int milkAmountMilliliters) {
    this.baseType = baseType;
    this.iceAmountGrams = iceAmountGrams;
    this.sugarAmountGrams = sugarAmountGrams;
    this.milkAmountMilliliters = milkAmountMilliliters;
  }

  @Override
  public void prepare() {
    System.out.println("Serving " + baseType + " with:");
    System.out.println(" - Ice: " + iceAmountGrams + " gr");
    System.out.println(" - Sugar: " + sugarAmountGrams + " gr");
    System.out.println(" - Milk: " + milkAmountMilliliters + " ml");
  }
}
