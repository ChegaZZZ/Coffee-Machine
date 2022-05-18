package machine;

import java.util.Scanner;

import static machine.Coffee.*;

public class CoffeeMachine {

    private int water;
    private int milk;
    private int coffeeBeans;
    private int cups;
    private int money;

    private final Scanner scanner = new Scanner(System.in);

    public CoffeeMachine(int water, int milk, int coffeeBeans, int cups, int money) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.cups = cups;
        this.money = money;
    }

    private int getWater() {
        return water;
    }

    private int getMilk() {
        return milk;
    }

    private int getCoffeeBeans() {
        return coffeeBeans;
    }

    private int getCups() {
        return cups;
    }

    private int getMoney() {
        return money;
    }

    private void showInfo() {
        System.out.printf("%nThe coffee machine has:%n");
        System.out.printf("%d ml of water%n", getWater());
        System.out.printf("%d ml of milk%n", getMilk());
        System.out.printf("%d g of coffee beans%n", getCoffeeBeans());
        System.out.printf("%d disposable cups%n", getCups());
        System.out.printf("$%d of money%n%n", getMoney());
    }

    public void selectAction(String action) {
        boolean isTrue = false;
        while (!isTrue) {

            switch (action) {
                case "buy" -> buyCoffee();
                case "fill" -> fillUpSupplies();
                case "take" -> takeMoney();
                case "remaining" -> showInfo();
                case "exit" -> isTrue = true;
            }

            if (!isTrue) {
                System.out.printf("Write action (buy, fill, take, remaining, exit):%n");
                action = scanner.next();
            }
        }
    }

    private void buyCoffee() {
        System.out.printf("%nWhat do you want to buy? " +
                "1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:%n");
        String option = scanner.next();

        switch (option) {
            case "back":
                System.out.println();
                break;
            case "1":
                if (checkEspressoIsTrue()) {
                    buyEspresso();
                }
                break;
            case "2":
                if (checkLatteIsTrue()) {
                    buyLatte();
                }
                break;
            case "3":
                if (checkCappuccinoIsTrue()) {
                    buyCappuccino();
                }
                break;
            default:
                break;
        }
    }

    private void buyEspresso() {
        water -= ESPRESSO.water;
        coffeeBeans -= ESPRESSO.coffeeBeans;
        money += ESPRESSO.price;
        cups--;
    }

    private void buyLatte() {
        water -= LATTE.water;
        milk -= LATTE.milk;
        coffeeBeans -= LATTE.coffeeBeans;
        money += LATTE.price;
        cups--;
    }

    private void buyCappuccino() {
        water -= CAPPUCCINO.water;
        milk -= CAPPUCCINO.milk;
        coffeeBeans -= CAPPUCCINO.coffeeBeans;
        money += CAPPUCCINO.price;
        cups--;
    }

    private boolean checkEspressoIsTrue() {
        if (water >= ESPRESSO.water && coffeeBeans >= ESPRESSO.coffeeBeans && cups >= 0) {
            System.out.printf("I have enough resources, making you a coffee!%n%n");
            return true;
        } else if (water < ESPRESSO.water) {
            System.out.printf("Sorry, not enough water!%n%n");
            return false;
        } else if (coffeeBeans < ESPRESSO.coffeeBeans) {
            System.out.printf("Sorry, not enough coffee beans!%n%n");
            return false;
        } else {
            System.out.printf("Sorry, not enough disposable cups!%n%n");
            return false;
        }
    }

    private boolean checkLatteIsTrue() {
        if (water >= LATTE.water && coffeeBeans >= LATTE.coffeeBeans && milk >= LATTE.milk && cups >= 0) {
            System.out.printf("I have enough resources, making you a coffee!%n%n");
            return true;
        } else if (water < LATTE.water) {
            System.out.printf("Sorry, not enough water!%n%n");
            return false;
        } else if (milk < LATTE.milk) {
            System.out.printf("Sorry, not enough milk!%n%n");
            return false;
        } else if (coffeeBeans < LATTE.coffeeBeans) {
            System.out.printf("Sorry, not enough coffee beans!%n%n");
            return false;
        } else {
            System.out.printf("Sorry, not enough disposable cups!%n%n");
            return false;
        }
    }

    private boolean checkCappuccinoIsTrue() {
        if (water >= CAPPUCCINO.water && coffeeBeans >= CAPPUCCINO.coffeeBeans && milk >= CAPPUCCINO.milk &&
                cups >= 0) {
            System.out.printf("I have enough resources, making you a coffee!%n%n");
            return true;
        } else if (water < CAPPUCCINO.water) {
            System.out.printf("Sorry, not enough water!%n%n");
            return false;
        } else if (milk < CAPPUCCINO.milk) {
            System.out.printf("Sorry, not enough milk!%n%n");
            return false;
        } else if (coffeeBeans < CAPPUCCINO.coffeeBeans) {
            System.out.printf("Sorry, not enough coffee beans!%n%n");
            return false;
        } else {
            System.out.printf("Sorry, not enough disposable cups!%n%n");
            return false;
        }
    }

    private void fillUpSupplies() {
        System.out.println("\nWrite how many ml of water you want to add:");
        int addWater = scanner.nextInt();

        System.out.println("Write how many ml of milk you want to add:");
        int addMilk = scanner.nextInt();

        System.out.println("Write how many grams of coffee beans you want to add:");
        int addCoffeeBeans = scanner.nextInt();

        System.out.println("Write how many disposable cups of coffee you want to add:");
        int addCups = scanner.nextInt();

        water += addWater;
        milk += addMilk;
        coffeeBeans += addCoffeeBeans;
        cups += addCups;

        System.out.println();
    }

    private void takeMoney() {
        System.out.printf("%nI gave you $%d%n%n", money);
        money -= money;
    }
}

