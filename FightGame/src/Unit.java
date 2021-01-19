public class Unit {

    private final String NAME_DEFAULT = "Игорь";
    private final int HEALTH_DEFAULT = 1;
    private final int PHYSICAL_DAMAGE_DEFAULT = 1;
    private final int MAGIC_DAMAGE_DEFAULT = 1;

    private String name;
    private int health;
    private int physicalDamage;
    private int magicDamage;

    public Unit(String name, int health, int physicalDamage, int magicDamage) {
        this.setName(name);
        this.setHealth(health);
        this.setPhysicalDamage(physicalDamage);
        this.setMagicDamage(magicDamage);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name.trim();
        if (!name.equals("")) {
            this.name = name;
        } else {
            this.name = NAME_DEFAULT;
            System.out.println(FightMessagesUtil.buildDefaultNameMessage(this));
        }
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health > 0) {
            this.health = health;
        } else {
            this.health = HEALTH_DEFAULT;
            System.out.println(FightMessagesUtil.buildNullHealthMessage(HEALTH_DEFAULT));
        }
    }

    public int getPhysicalDamage() {
        return physicalDamage;
    }

    public void setPhysicalDamage(int physicalDamage) {
        if (physicalDamage > 0) {
            this.physicalDamage = physicalDamage;
        } else {
            this.physicalDamage = PHYSICAL_DAMAGE_DEFAULT;
            System.out.println(FightMessagesUtil.buildNullPhysicalAttackMessage(PHYSICAL_DAMAGE_DEFAULT));
        }
    }

    public int getMagicDamage() {
        return magicDamage;
    }

    public void setMagicDamage(int magicDamage) {
        if (magicDamage > 0) {
            this.magicDamage = magicDamage;
        } else {
            this.magicDamage = MAGIC_DAMAGE_DEFAULT;
            System.out.println(FightMessagesUtil.buildMNullMagicMessage(MAGIC_DAMAGE_DEFAULT));
        }
    }

    public void physicalHit(int physicalDamage){
        this.health -= physicalDamage;
        if(health < 0)
            health = 0;
    }

    public void magicHit(int magic_damage){
        this.health -= magic_damage;
        if(health < 0)
            health = 0;
    }
}
