package ru.itmo.tofutogot.command.impl;

import ru.itmo.tofutogot.command.Command;
import ru.itmo.tofutogot.manager.CollectionManager;
import ru.itmo.tofutogot.model.SpaceMarine;

// Выводит элементы с данным количеством сердец

public class FBHC extends Command {
    private final CollectionManager collectionManager;

    public FBHC(CollectionManager collectionManager) {
        super("fbhc");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 1) {
            System.out.println("Ошибка: необходимо указать количество сердец (целое число).");
            return;
        }

        try {
            int heartCount = Integer.parseInt(args[0]);
            boolean found = false;

            for (SpaceMarine marine : collectionManager.getCollection()) {
                if (marine.getHeartCount() == heartCount) {
                    System.out.println(marine);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("Нет десантников с heartCount = " + heartCount);
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: аргумент должен быть целым числом.");
        }
    }

    @Override
    public String getHelp() {
        return "fbhc <heartCount> - (filter by heart count) вывести всех десантников с заданным количеством сердец";
    }
}

