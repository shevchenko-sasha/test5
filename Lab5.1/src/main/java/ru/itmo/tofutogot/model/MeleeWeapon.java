package ru.itmo.tofutogot.model;

//Перечисление типов оружия

public enum MeleeWeapon {
    CHAIN_SWORD,
    POWER_SWORD,
    CHAIN_AXE,
    MANREAPER,
    LIGHTING_CLAW;

    /**
     * Возвращает отформатированное название оружия.
     * @return читаемое название оружия (например, "Chain Sword")
     */

    @Override
    public String toString() {
        return name().toLowerCase().replace("_", " ");
    }

    /**
     * Возвращает строку со всеми доступными вариантами оружия.
     * @return строка с перечислением всех видов оружия
     */

    public static String listValues() {
        StringBuilder sb = new StringBuilder("Доступные типы оружия:\n");
        for (MeleeWeapon weapon : MeleeWeapon.values()) {
            sb.append("- ").append(weapon.name()).append(" (").append(weapon.toString()).append(")\n");
        }
        return sb.toString();
    }
}
