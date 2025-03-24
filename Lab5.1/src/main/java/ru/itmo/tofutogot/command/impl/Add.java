package ru.itmo.tofutogot.command.impl;
import ru.itmo.tofutogot.command.Command;
import ru.itmo.tofutogot.manager.CollectionManager;
import ru.itmo.tofutogot.util.CommandScanner;
import ru.itmo.tofutogot.model.SpaceMarine;

// Добавляет элемент в коллекцию

public class Add extends Command {
    private final CollectionManager collectionManager;
    private final CommandScanner commandScanner;

    public Add(CollectionManager collectionManager, CommandScanner commandScanner) {
        super("add");
        this.collectionManager = collectionManager;
        this.commandScanner = commandScanner;
    }

    @Override
    public void execute(String[] args) {
        try {
            long id = collectionManager.generateId();
            SpaceMarine marine = commandScanner.readSpaceMarine(id);
            collectionManager.add(marine);
            System.out.println("Элемент добавлен.");
        } catch (Exception e) {
            System.out.println("Ошибка при добавлении элемента: " + e.getMessage());
        }
    }

    @Override
    public String getHelp() {
        return "add - добавить новый элемент в коллекцию (без аргументов)";
    }
}

