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
            System.out.println("Ошибка! Имя не может быть пустым! Присвоено значение по-умолчанию "
                    + NAME_DEFAULT);
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
            System.out.println("Ошибка! Здоровье не может быть равно 0! Присвоено значение по-умолчанию "
                    + HEALTH_DEFAULT);
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
            System.out.println("Ошибка! Физическая атака не может быть равна 0! Присвоено значение по-умолчанию "
                    + PHYSICAL_DAMAGE_DEFAULT);
        }
    }

    public int getMagicDamage() {
        return magicDamage;
    }

    public void setMagicDamage(int magic_damage) {
        if (magic_damage > 0) {
            this.magicDamage = magic_damage;
        } else {
            this.magicDamage = MAGIC_DAMAGE_DEFAULT;
            System.out.println("Ошибка! Магическая атака не может быть равна 0! Присвоено значение по-умолчанию "
                    + MAGIC_DAMAGE_DEFAULT);
        }
    }

    public void physicalHit(int physicalDamage){
        this.health -= physicalDamage;
    }

    public void magicHit(int magic_damage){
        this.health -= magicDamage;
    }

    @Override
    public String toString() {
        return "Поздравляем! Вы создали персонажа " +
                " по имени " + name +
                ", со здоровьем " + health +
                ", его физический урон " + physicalDamage +
                ", а его магическая атака " + magicDamage +
                ". Приятной игры!";
    }
}
