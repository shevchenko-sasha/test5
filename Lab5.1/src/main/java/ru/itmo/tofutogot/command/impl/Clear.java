package ru.itmo.tofutogot.command.impl;

import ru.itmo.tofutogot.command.Command;
import ru.itmo.tofutogot.manager.CollectionManager;

// Очищает коллекцию

public class Clear extends Command {
    private final CollectionManager collectionManager;

    public Clear(CollectionManager collectionManager) {
        super("clear");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        collectionManager.getCollection().clear();
        System.out.println("Коллекция очищена.");
    }

    @Override
    public String getHelp() {
        return "clear - очистить коллекцию";
    }
}

