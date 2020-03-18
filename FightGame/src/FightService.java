import java.util.Random;

public class FightService {

    public void fight(Unit unit1, Unit unit2) {
        Random random = new Random(System.currentTimeMillis());
        while (unit1.getHealth() > 0 && unit2.getHealth() > 0){
            int physicalDamage1 = unit1.getPhysicalDamage();
            int magicDamage1 = unit1.getMagicDamage();
            unit2.physicalHit(physicalDamage1);
            System.out.println(FightMessagesUtil.buildPhysicalDamageMessage(unit1, physicalDamage1, unit2));

            if(random.nextInt(100) < 30){
                unit2.magicHit(magicDamage1);
                System.out.println(FightMessagesUtil.buildMagicDamageMessage(unit1, magicDamage1, unit2));
            }
            int physicalDamage2 = unit2.getPhysicalDamage();
            int magicDamage2 = unit2.getMagicDamage();
            unit1.physicalHit(physicalDamage2);
            System.out.println(FightMessagesUtil.buildPhysicalDamageMessage(unit2, physicalDamage2, unit1));
            if(random.nextInt(100) < 30){
                unit1.magicHit(magicDamage2);
                System.out.println(FightMessagesUtil.buildMagicDamageMessage(unit2, magicDamage2, unit1));
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
