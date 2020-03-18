import java.util.Scanner;

public class Interface {

    public void readConsole() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Добро пожаловать в игру!\n" +
                "Введите 1, чтобы создать случайный поединок\n" +
                "Введите 2, чтобы создать собственных персонажей\n" +
                "Введите 0, чтобы выйти");

        if (sc.hasNextInt()) {
            int number = sc.nextInt();
            chooseGameType(number);

        } else {
            System.out.println("Извините, но это явно не число. Перезапустите программу и попробуйте снова!");
        }
        sc.close();
    }

    public void chooseGameType(int number) {
        Scanner scannerUserInput = new Scanner(System.in);
        int userInput = scannerUserInput.nextInt();
        while (userInput > 0 || userInput < 2) {
            if (number == 1) {
                System.out.println("Случайный поединок");
            }
            if (number == 2) {
                Scanner scannerForCreatingUnits = new Scanner(System.in);
                System.out.println("Введите имя первого персонажа");
                String nameUnit1 = scannerForCreatingUnits.nextLine();
                System.out.println("Введите уровень здоровья первого персонажа");
                int healthUnit1 = scannerForCreatingUnits.nextInt();
                System.out.println("Введите физическую атаку первого персонажа");
                int physicalDamageUnit1 = scannerForCreatingUnits.nextInt();
                System.out.println("Введите магическую атаку первого персонажа");
                int magicDamageUnit1 = scannerForCreatingUnits.nextInt();
                System.out.println(FightMessagesUtil.buildCreateUnitMessage(nameUnit1,
                        healthUnit1,
                        physicalDamageUnit1,
                        magicDamageUnit1));

                System.out.println("Введите имя второго персонажа");
                String nameUnit2 = scannerForCreatingUnits.nextLine();
                System.out.println("Введите уровень здоровья второго персонажа");
                int healthUnit2 = scannerForCreatingUnits.nextInt();
                System.out.println("Введите физическую атаку второго персонажа");
                int physicalDamageUnit2 = scannerForCreatingUnits.nextInt();
                System.out.println("Введите магическую атаку второго персонажа");
                int magicDamageUnit2 = scannerForCreatingUnits.nextInt();
                System.out.println(FightMessagesUtil.buildCreateUnitMessage(nameUnit2,
                        healthUnit2,
                        physicalDamageUnit2,
                        magicDamageUnit2));
            }
            if (number == 0) {
                System.out.println("Завершение программы. Поиграем в другой раз!");
                break;
            }
        }
        System.out.println("Вы ввели неверное число. Введите 0, 1 или 2");
        scannerUserInput.close();
    }
}
