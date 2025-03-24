package ru.itmo.tofutogot.command.impl;

import ru.itmo.tofutogot.command.Command;
import ru.itmo.tofutogot.manager.CollectionManager;
import ru.itmo.tofutogot.model.*;
import java.util.Random;

// Рандомно генерирует n-е количество десантников, для упрощения тестов

public class Generate extends Command {
    private final CollectionManager collectionManager;
    private final Random random = new Random();

    public Generate(CollectionManager collectionManager) {
        super("generate");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 1) {
            System.out.println("Использование: generate <количество>");
            return;
        }

        try {
            int count = Integer.parseInt(args[0]);
            if (count <= 0) {
                System.out.println("Количество должно быть больше 0.");
                return;
            }

            for (int i = 0; i < count; i++) {
                long id = collectionManager.generateId();
                SpaceMarine marine = generateRandomMarine(id);
                collectionManager.add(marine);
            }

            System.out.println("Добавлено " + count + " случайных десантников.");
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: аргумент должен быть числом.");
        }
    }

    @Override
    public String getHelp() {
        return "generate <n> - создать n случайных десантников";
    }

    private SpaceMarine generateRandomMarine(long id) {
        String name = "Marine" + id;
        Coordinates coordinates = new Coordinates(random.nextInt(1000), random.nextFloat() * 876);
        int health = 1 + random.nextInt(1000);
        int heartCount = 1 + random.nextInt(3); // 1–3
        Long height = random.nextBoolean() ? random.nextLong(250) + 100 : null;
        MeleeWeapon weapon = randomEnum(MeleeWeapon.class);
        Chapter chapter = random.nextInt(4) == 0 ? null : new Chapter("Chapter" + random.nextInt(100), "World" + random.nextInt(50));


        return new SpaceMarine(id, name, coordinates, health, heartCount, height, weapon, chapter);
    }

    private <T extends Enum<T>> T randomEnum(Class<T> clazz) {
        T[] values = clazz.getEnumConstants();
        return values[random.nextInt(values.length)];
    }
}

