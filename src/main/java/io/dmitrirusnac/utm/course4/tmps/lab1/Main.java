package io.dmitrirusnac.utm.course4.tmps.lab1;

import io.dmitrirusnac.utm.course4.tmps.lab1.factory.DrinkFactory;
import io.dmitrirusnac.utm.course4.tmps.lab1.logger.OrderLogger;
import io.dmitrirusnac.utm.course4.tmps.lab1.model.CustomDrink;
import io.dmitrirusnac.utm.course4.tmps.lab1.model.Drink;
import io.dmitrirusnac.utm.course4.tmps.lab1.model.DrinkType;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    OrderLogger logger = OrderLogger.getInstance();

    while (true) {
      System.out.println("\n===== Drink Builder Café =====");
      System.out.println("1. Order basic drink");
      System.out.println("2. Order customized drink");
      System.out.println("3. Show order history");
      System.out.println("0. Exit");
      System.out.print("Choose an option: ");

      int choice = scanner.nextInt();
      scanner.nextLine(); // Clear buffer

      switch (choice) {
        case 1:
          handleBasicDrink(scanner, logger);
          break;
        case 2:
          handleCustomDrink(scanner, logger);
          break;
        case 3:
          logger.printOrders();
          break;
        case 0:
          System.out.println("Thank you! Come again.");
          return;
        default:
          System.out.println("Invalid choice.");
      }
    }
  }

  private static void handleBasicDrink(Scanner scanner, OrderLogger logger) {
    DrinkType drinkType = promptDrinkType(scanner);
    if (drinkType == null) return;

    Drink drink = DrinkFactory.createDrink(drinkType);
    drink.prepare();

    logger.log("Basic order: " + drinkType.name());
  }

  private static void handleCustomDrink(Scanner scanner, OrderLogger logger) {
    DrinkType drinkType = promptDrinkType(scanner);
    if (drinkType == null) return;

    Drink baseDrink = DrinkFactory.createDrink(drinkType);

    System.out.print("How many grams of sugar? ");
    int sugar = scanner.nextInt();
    System.out.print("How many grams of ice? ");
    int ice = scanner.nextInt();
    System.out.print("How many ml of milk? ");
    int milk = scanner.nextInt();
    scanner.nextLine(); // Clear buffer

    Drink custom = new CustomDrink(drinkType, sugar, milk, ice);
    custom.prepare();

    logger.log(
        "Custom order: "
            + drinkType.name()
            + " | Sugar: "
            + sugar
            + " | Milk: "
            + milk
            + " | Ice: "
            + ice);
  }

  private static DrinkType promptDrinkType(Scanner scanner) {
    System.out.println("Available drink types:");
    for (DrinkType type : DrinkType.values()) {
      System.out.println(" - " + type.name());
    }

    System.out.print("Your choice: ");
    String input = scanner.nextLine().toUpperCase();

    try {
      return DrinkType.valueOf(input);
    } catch (IllegalArgumentException e) {
      System.out.println("Invalid drink type.");
      return null;
    }
  }
}
