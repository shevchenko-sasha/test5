package ru.itmo.tofutogot.command.impl;

import ru.itmo.tofutogot.command.Command;
import ru.itmo.tofutogot.manager.CollectionManager;

import java.util.Collections;

// Сортирует коллекцию по возрастанию id

public class Sort extends Command {
    private final CollectionManager collectionManager;

    public Sort(CollectionManager collectionManager) {
        super("sort");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        Collections.sort(collectionManager.getCollection());
        System.out.println("Коллекция отсортирована по возрастанию id.");
    }

    @Override
    public String getHelp() {
        return "sort - отсортировать коллекцию в естественном порядке (по id)";
    }
}
