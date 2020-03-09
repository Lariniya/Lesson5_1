import java.util.Random;

public class FightService {

    public void fight(Unit unit1, Unit unit2) {
        Random random = new Random(System.currentTimeMillis());
        while (unit1.getHealth() > 0 && unit2.getHealth() > 0){
            int physical_damage1 = unit1.getPhysical_Damage();
            int magic_damage1 = unit1.getMagic_Damage();
            unit2.physicalHit(physical_damage1);
            System.out.println(unit1.getName() + " нанес " + physical_damage1 + " физического урона " + unit2.getName());
            if(random.nextInt(100) < 30){
                unit2.magicHit(magic_damage1);
                System.out.println(unit1.getName() + " нанес " + magic_damage1 + " магического урона " + unit2.getName());
            }
            int physical_damage2 = unit2.getPhysical_Damage();
            int magic_damage2 = unit2.getMagic_Damage();
            unit1.physicalHit(physical_damage2);
            System.out.println(unit2.getName() + " нанес " + physical_damage2 + " физического урона " + unit1.getName());
            if(random.nextInt(100) < 30){
                unit1.magicHit(magic_damage2);
                System.out.println(unit2.getName() + " нанес " + magic_damage2 + " магического урона " + unit1.getName());
            }
        }
        if (unit1.getHealth() > 0){
            System.out.println("Победитель " + unit1.getName());
        } else if (unit2.getHealth() > 0 ){
            System.out.println("Победитель " + unit2.getName());
        } else {
            System.out.println("Все умерли");
        }
    }
}
