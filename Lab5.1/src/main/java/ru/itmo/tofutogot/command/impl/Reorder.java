package ru.itmo.tofutogot.command.impl;

import ru.itmo.tofutogot.command.Command;
import ru.itmo.tofutogot.manager.CollectionManager;

import java.util.Collections;

// Отсортировать коллекцию в порядке, обратном нынешнему

public class Reorder extends Command {
    private final CollectionManager collectionManager;

    public Reorder(CollectionManager collectionManager) {
        super("reorder");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        if (collectionManager.getCollection().isEmpty()) {
            System.out.println("Коллекция пуста, перестановка невозможна.");
            return;
        }

        Collections.reverse(collectionManager.getCollection());
        System.out.println("Коллекция была переставлена в обратном порядке.");
    }

    @Override
    public String getHelp() {
        return "reorder - переставить элементы коллекции в обратном порядке";
    }
}

