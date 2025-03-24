package ru.itmo.tofutogot.command.impl;

import ru.itmo.tofutogot.command.Command;
import ru.itmo.tofutogot.manager.CollectionManager;
import ru.itmo.tofutogot.model.SpaceMarine;

// Выводит в стандартный поток вывода все элементы коллекции в строковом представлении

public class Show extends Command {
    private final CollectionManager collectionManager;

    public Show(CollectionManager collectionManager) {
        super("show");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        if (collectionManager.getCollection().isEmpty()) {
            System.out.println("Коллекция пуста.");
        } else {
            for (SpaceMarine marine : collectionManager.getCollection()) {
                System.out.println(marine);
            }
        }
    }

    @Override
    public String getHelp() {
        return "show - вывести все элементы коллекции в строковом представлении";
    }
}

