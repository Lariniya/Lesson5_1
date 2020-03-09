public class Unit {

    private final String NAME_DEFAULT = "Игорь";
    private final int HEALTH_DEFAULT = 1;
    private final int PHYSICAL_DAMAGE_DEFAULT = 1;
    private final int MAGIC_DAMAGE_DEFAULT = 1;

    private String name;
    private int health;
    private int physical_damage;
    private int magic_damage;

    public Unit(String name, int health, int physical_damage, int magic_damage) {
        this.setName(name);
        this.setHealth(health);
        this.setPhysical_Damage(physical_damage);
        this.setMagic_Damage(magic_damage);
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

    public int getPhysical_Damage() {
        return physical_damage;
    }

    public void setPhysical_Damage(int physical_damage) {
        if (physical_damage > 0) {
            this.physical_damage = physical_damage;
        } else {
            this.physical_damage = PHYSICAL_DAMAGE_DEFAULT;
            System.out.println("Ошибка! Физическая атака не может быть равна 0! Присвоено значение по-умолчанию "
                    + PHYSICAL_DAMAGE_DEFAULT);
        }
    }

    public int getMagic_Damage() {
        return magic_damage;
    }

    public void setMagic_Damage(int magic_damage) {
        if (magic_damage > 0) {
            this.magic_damage = magic_damage;
        } else {
            this.magic_damage = MAGIC_DAMAGE_DEFAULT;
            System.out.println("Ошибка! Магическая атака не может быть равна 0! Присвоено значение по-умолчанию "
                    + MAGIC_DAMAGE_DEFAULT);
        }
    }

    public void physicalHit(int physical_damage){
        this.health -= physical_damage;
    }

    public void magicHit(int magic_damage){
        this.health -= magic_damage;
    }

    @Override
    public String toString() {
        return "Поздравляем! Вы создали персонажа " +
                " по имени " + name +
                ", со здоровьем " + health +
                ", его физический урон " + physical_damage +
                ", а его магическая атака " + magic_damage +
                ". Приятной игры!";
    }
}
