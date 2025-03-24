package ru.itmo.tofutogot.util;

import ru.itmo.tofutogot.model.*;

public class CommandScanner {
    private InputManager input;

    public CommandScanner(InputManager input) {
        this.input = input;
    }

    public SpaceMarine readSpaceMarine(long id) {
        String name = readString("Введите имя десантника:");
        Coordinates coordinates = readCoordinates();
        int health = readInt("Введите здоровье (> 0):", x -> x > 0);
        int heartCount = readInt("Введите количество сердец (1–3):", x -> x > 0 && x <= 3);
        Long height = readNullableLong("Введите рост (или оставьте пустым):");
        MeleeWeapon weapon = readEnum(MeleeWeapon.class, "Выберите оружие (или оставьте пустым):");
        Chapter chapter = readChapter();

        return new SpaceMarine(id, name, coordinates, health, heartCount, height, weapon, chapter);
    }

    private String readString(String prompt) {
        while (true) {
            System.out.println(prompt);
            String inputLine = input.nextLine().trim();
            if (!inputLine.isBlank()) return inputLine;
            System.out.println("Значение не может быть пустым");
        }
    }

    private int readInt(String prompt, java.util.function.IntPredicate condition) {
        while (true) {
            System.out.println(prompt);
            try {
                int value = Integer.parseInt(input.nextLine().trim());
                if (condition.test(value)) return value;
            } catch (Exception ignored) {}
            System.out.println("Неверный ввод, попробуйте снова.");
        }
    }

    private Long readNullableLong(String prompt) {
        System.out.println(prompt);
        String inputLine = input.nextLine().trim();
        if (inputLine.isEmpty()) return null;
        try {
            return Long.parseLong(inputLine);
        } catch (Exception e) {
            System.out.println("Неверное значение, установлено null.");
            return null;
        }
    }

    private Coordinates readCoordinates() {
        int x = readInt("Введите координату X:", v -> true);
        float y = readFloat("Введите координату Y (≤ 876):", v -> v <= 876);
        return new Coordinates(x, y);
    }

    private float readFloat(String prompt, java.util.function.Predicate<Float> condition) {
        while (true) {
            System.out.println(prompt);
            try {
                float value = Float.parseFloat(input.nextLine().trim());
                if (condition.test(value)) return value;
            } catch (Exception ignored) {}
            System.out.println("Неверный ввод, попробуйте снова.");
        }
    }

    private Chapter readChapter() {
        String name = readString("Введите название главы:");
        System.out.println("Введите название мира (можно оставить пустым):");
        String world = input.nextLine().trim();
        return new Chapter(name, world.isEmpty() ? null : world);
    }

    private <T extends Enum<T>> T readEnum(Class<T> enumClass, String prompt) {
        System.out.println(prompt);
        for (T constant : enumClass.getEnumConstants()) {
            System.out.println("- " + constant.name());
        }
        String inputLine = input.nextLine().trim().toUpperCase();
        if (inputLine.isEmpty()) return null;
        try {
            return Enum.valueOf(enumClass, inputLine);
        } catch (IllegalArgumentException e) {
            System.out.println("Неверное значение, установлено null.");
            return null;
        }
    }

    public InputManager getInputManager() {
        return input;
    }

    public void setInputManager(InputManager input) {
        this.input = input;
    }

}

