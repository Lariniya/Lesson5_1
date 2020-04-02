import java.util.Random;

public class FightService {

    public FightLog fight(Unit unit1, Unit unit2) {
        Random random = new Random(System.currentTimeMillis());
        FightLog log = new FightLog();
        while (unit1.getHealth() > 0 && unit2.getHealth() > 0) {
            attack(unit1, unit2, log, random);
            attack(unit2, unit1, log, random);
        }

        fightResult(unit1, unit2, log);
        return log;
    }

    private void attack(Unit attacker, Unit target, FightLog log, Random random) {
        int physicalDamage = attacker.getPhysicalDamage();
        target.physicalHit(physicalDamage);
        log.add(FightMessagesUtil.buildPhysicalDamageMessage(attacker, physicalDamage, target));

        if (random.nextInt(100) < 30) {
            int magicDamage = attacker.getMagicDamage();
            target.magicHit(magicDamage);
            log.add(FightMessagesUtil.buildMagicDamageMessage(attacker, magicDamage, target));
        }
    }

    private void fightResult(Unit unit1, Unit unit2, FightLog log) {
        if (unit1.getHealth() > 0) {
            log.add("Победитель " + unit1.getName());
            return;
        }

        if (unit2.getHealth() > 0) {
            log.add("Победитель " + unit2.getName());
            return;
        }

        log.add("Все умерли");
    }
}
