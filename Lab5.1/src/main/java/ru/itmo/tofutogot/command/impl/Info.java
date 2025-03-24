package ru.itmo.tofutogot.command.impl;

import ru.itmo.tofutogot.command.Command;
import ru.itmo.tofutogot.manager.CollectionManager;

// Выводит в стандартный поток вывода информацию о коллекции

public class Info extends Command {
    private final CollectionManager collectionManager;

    public Info(CollectionManager collectionManager) {
        super("info");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        System.out.println("Тип коллекции: Vector<SpaceMarine>");
        System.out.println("Дата инициализации: " + collectionManager.getInitializationDate());
        System.out.println("Количество элементов: " + collectionManager.getCollection().size());
    }

    @Override
    public String getHelp() {
        return "info - вывести информацию о коллекции (тип, дата инициализации, размер)";
    }
}

