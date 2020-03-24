public class FightMessagesUtil {

    public static final String DEFAULT_NAME_MESSAGE = "Ошибка! Имя не может быть пустым! Присвоено значение по-умолчанию %s";
    public static final String PHYSICAL_DAMAGE_MESSAGE = "%s нанес %s физического урона %s";
    public static final String MAGIC_DAMAGE_MESSAGE = "%s нанес %s физического урона %s";
    public static final String NULL_HEALTH_ERROR_MESSAGE =
            "Ошибка! Здоровье не может быть равно 0! Присвоено значение по-умолчанию %s";
    public static final String NULL_PHYSICAL_ATTACK_ERROR_MESSAGE =
            "Ошибка! Физическая атака не может быть равна 0! Присвоено значение по-умолчанию %s";
    public static final String NULL_MAGIC_ERROR_MESSAGE =
            "Ошибка! Магическая атака не может быть равна 0! Присвоено значение по-умолчанию %s";
    public static final String CREATE_UNIT_MESSAGE = "Поздравляем! Вы создали персонажа" +
            " по имени %s, со здоровьем %s, его физический урон %s, а его магическая атака %s";
    public static final String CREATE_RANDOM_UNIT_MESSAGE = "Поздравляем! Мы создали для вас персонажа" + //пока вы валялись на диване
            " по имени %s, со здоровьем %s, его физический урон %s, а его магическая атака %s";

    public static String buildDefaultNameMessage(Unit unit) {
        return String.format(DEFAULT_NAME_MESSAGE, unit.getName());
    }

    public static String buildPhysicalDamageMessage(Unit unitAttacker, int physicalDamage, Unit unitTarget) {
        return String.format(PHYSICAL_DAMAGE_MESSAGE, unitAttacker.getName(), physicalDamage, unitTarget.getName());
    }

    public static String buildMagicDamageMessage(Unit unitAttacker, int magicDamage, Unit unitTarget) {
        return String.format(MAGIC_DAMAGE_MESSAGE, unitAttacker.getName(), magicDamage, unitTarget.getName());
    }

    public static String buildNullHealthMessage(int healthDefault) {
        return String.format(NULL_HEALTH_ERROR_MESSAGE, healthDefault);
    }

    public static String buildNullPhysicalAttackMessage(int physicalDamageDefault) {
        return String.format(NULL_PHYSICAL_ATTACK_ERROR_MESSAGE, physicalDamageDefault);
    }

    public static String buildMNullMagicMessage(int magicDamageDefault) {
        return String.format(NULL_MAGIC_ERROR_MESSAGE, magicDamageDefault);
    }

    public static String buildCreateUnitMessage(String name, int health, int physicalDamage, int magicDamage) {
        return String.format(CREATE_UNIT_MESSAGE, name, health, physicalDamage, magicDamage);
    }

    public static String buildCreateRandomUnitMessage(String name, int health, int physicalDamage, int magicDamage) {
        return String.format(CREATE_RANDOM_UNIT_MESSAGE, name, health, physicalDamage, magicDamage);
    }
}
