import java.util.Random;
import java.util.Scanner;

public class Interface {

    private static final int MAX_HEALTH_RAND = 100;
    private static final int MAX_PHYSICAL_ATTACK_RAND = 50;
    private static final int MAX_MAGIC_ATTACK_RAND = 70;
    private static final String[] ARRAY_NAMES_RAND = {"Крейг","Макс","Сара","Энди","Тамара", "Зинаида", "Паркинсон"};


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
        if (number == 1) {
            System.out.println("Случайный поединок");
            Random random = new Random(System.currentTimeMillis());
            String nameUnit1 = ARRAY_NAMES_RAND[random.nextInt(ARRAY_NAMES_RAND.length)];
            int healthUnit1 = random.nextInt(MAX_HEALTH_RAND);
            int physicalDamageUnit1 = random.nextInt(MAX_PHYSICAL_ATTACK_RAND);
            int magicDamageUnit1 = random.nextInt(MAX_MAGIC_ATTACK_RAND);

            Unit unit1 = new Unit(nameUnit1, healthUnit1, physicalDamageUnit1, magicDamageUnit1);
            System.out.println(FightMessagesUtil.buildCreateRandomUnitMessage(nameUnit1,
                    healthUnit1,
                    physicalDamageUnit1,
                    magicDamageUnit1));

            String nameUnit2 = ARRAY_NAMES_RAND[random.nextInt(ARRAY_NAMES_RAND.length)];
            int healthUnit2 = random.nextInt(MAX_HEALTH_RAND);
            int physicalDamageUnit2 = random.nextInt(MAX_PHYSICAL_ATTACK_RAND);
            int magicDamageUnit2 = random.nextInt(MAX_MAGIC_ATTACK_RAND);

            Unit unit2 = new Unit(nameUnit2, healthUnit2, physicalDamageUnit2, magicDamageUnit2);
            System.out.println(FightMessagesUtil.buildCreateRandomUnitMessage(nameUnit2,
                    healthUnit2,
                    physicalDamageUnit2,
                    magicDamageUnit2));

            FightService fightService = new FightService();
            fightService.fight(unit1, unit2);
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

                Unit unit1 = new Unit(nameUnit1, healthUnit1, physicalDamageUnit1, magicDamageUnit1);
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

                Unit unit2 = new Unit(nameUnit2, healthUnit2, physicalDamageUnit2, magicDamageUnit2);
                System.out.println(FightMessagesUtil.buildCreateUnitMessage(nameUnit2,
                        healthUnit2,
                        physicalDamageUnit2,
                        magicDamageUnit2));

                FightService fightService = new FightService();
                fightService.fight(unit1, unit2);
            }
            if (number == 0) {
                System.out.println("Завершение программы. Поиграем в другой раз!");
            }

        if (number < 0 || number > 2)
        System.out.println("Вы ввели неверное число. Введите 0, 1 или 2");
    }
}
