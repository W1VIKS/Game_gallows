import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        GameController gameController = new GameController();

        System.out.println("=================================");
        System.out.println("  ДОБРО ПОЖАЛОВАТЬ В «ВИСЕЛИЦУ»!  ");
        System.out.println("=================================");


        while (true) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Начать новую игру");
            System.out.println("2. Выйти из приложения");
            System.out.print("Ваш выбор: ");

            String choice = scanner.nextLine().trim();

            if (choice.equals("1")) {

                gameController.startNewGame();
            } else if (choice.equals("2")) {
                System.out.println("Спасибо за игру! До встречи.");
                break;
            } else {
                System.out.println("Неверный ввод. Пожалуйста, введите 1 или 2.");
            }
        }

        scanner.close();
    }
}