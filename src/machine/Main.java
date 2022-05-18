package machine;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine coffeeMachine = new CoffeeMachine(400, 540, 120, 9, 550);

        System.out.printf("Write action (buy, fill, take, remaining, exit):%n");
        String action = scanner.next();

        coffeeMachine.selectAction(action);
    }
}

