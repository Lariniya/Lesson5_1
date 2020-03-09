public class Main {

    public static void main(String[] args) {
        Unit unit1 = new Unit("Gregor", 20,4,1);
        System.out.println(unit1);

        Unit unit2 = new Unit("Mattew", 30,1,2);
        System.out.println(unit2);

        FightService fightService = new FightService();
        fightService.fight(unit1, unit2);
    }
}
