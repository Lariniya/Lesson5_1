import java.util.Random;
import java.util.Scanner;

public class Interface {

    private static final int USER_CHOICE_EXIT = 0;
    private static final int USER_CHOICE_DEFAULT_FIGHT = 1;
    private static final int USER_CHOICE_CUSTOM_FIGHT = 2;
    private static final int MAX_HEALTH_RAND = 100;
    private static final int MAX_PHYSICAL_ATTACK_RAND = 50;
    private static final int MAX_MAGIC_ATTACK_RAND = 70;
    private static final String[] ARRAY_NAMES_RAND =
            {"Крейг", "Макс", "Сара", "Энди", "Тамара", "Зинаида", "Паркинсон"};
    private static final String CREATE_FIRST_UNIT = "первого";
    private static final String CREATE_SECOND_UNIT = "второго";

    public int readInt(Scanner sc, String message) {
        System.out.println(message);
        if (sc.hasNextInt()) {
            return sc.nextInt();
        } else {
            System.out.println("Ошибка. Не смогли распознать число " + sc.nextLine());
            return readInt(sc, message);
        }
    }

    public void readConsole() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Добро пожаловать в игру!");
        int userChoice = readInt(sc,
                "Введите " + USER_CHOICE_DEFAULT_FIGHT + ", чтобы создать случайный поединок\n" +
                        "Введите " + USER_CHOICE_CUSTOM_FIGHT + ", чтобы создать собственных персонажей\n" +
                        "Введите " + USER_CHOICE_EXIT + ", чтобы выйти");
        chooseGameType(userChoice);
        sc.close();
    }

    private void chooseGameType(int userChoice) {
        if (userChoice == USER_CHOICE_DEFAULT_FIGHT) {
            createDefaultFight();
            return;
        }

        if (userChoice == USER_CHOICE_CUSTOM_FIGHT) {
            createCustomFight();
            return;
        }

        if (userChoice == USER_CHOICE_EXIT) {
            System.out.println("Завершение программы. Поиграем в другой раз!");
            return;
        }

        System.out.println("Вы ввели неверное число. Введите " + USER_CHOICE_EXIT + ", "
                    + USER_CHOICE_DEFAULT_FIGHT + " или " + USER_CHOICE_DEFAULT_FIGHT);
    }

    private Unit createDefaultUnit(Random random){
        String nameUnit = ARRAY_NAMES_RAND[random.nextInt(ARRAY_NAMES_RAND.length)];
        int healthUnit = random.nextInt(MAX_HEALTH_RAND);
        int physicalDamageUnit = random.nextInt(MAX_PHYSICAL_ATTACK_RAND);
        int magicDamageUnit = random.nextInt(MAX_MAGIC_ATTACK_RAND);

        Unit unit = new Unit(nameUnit, healthUnit, physicalDamageUnit, magicDamageUnit);
        System.out.println(FightMessagesUtil.buildCreateRandomUnitMessage(nameUnit,
                healthUnit,
                physicalDamageUnit,
                magicDamageUnit));
        return unit;
    }

    private Unit createCustomUnit(Scanner scannerForCreatingUnits, String unitNumber){
        System.out.println("Введите имя " + unitNumber + " персонажа");
        String nameUnit = scannerForCreatingUnits.nextLine();
        int healthUnit = readInt(scannerForCreatingUnits, "Введите уровень здоровья " + unitNumber + " персонажа");
        int physicalDamageUnit = readInt(scannerForCreatingUnits, "Введите физическую атаку " + unitNumber + " персонажа");
        int magicDamageUnit = readInt(scannerForCreatingUnits, "Введите магическую атаку " + unitNumber + " персонажа");

        Unit unit = new Unit(nameUnit, healthUnit, physicalDamageUnit, magicDamageUnit);
        System.out.println(FightMessagesUtil.buildCreateUnitMessage(nameUnit,
                healthUnit,
                physicalDamageUnit,
                magicDamageUnit));
        return unit;
    }

    private void createDefaultFight(){
        System.out.println("Случайный поединок");
        Random random = new Random(System.currentTimeMillis());

        Unit unit1 = createDefaultUnit(random);
        Unit unit2 = createDefaultUnit(random);

        FightService fightService = new FightService();
        FightLog log = fightService.fight(unit1, unit2);
        print(log);
    }

    private void createCustomFight(){
        Scanner scannerForCreatingUnits = new Scanner(System.in);
        Unit unit1 = createCustomUnit(scannerForCreatingUnits, CREATE_FIRST_UNIT);

        scannerForCreatingUnits.nextLine(); //костыль

        Unit unit2 = createCustomUnit(scannerForCreatingUnits, CREATE_SECOND_UNIT);

        FightService fightService = new FightService();
        FightLog log = fightService.fight(unit1, unit2);
        print(log);
    }

    private void print(FightLog log){
        for (String message : log.getMessages()){
            System.out.println(message);
        }
    }
}
