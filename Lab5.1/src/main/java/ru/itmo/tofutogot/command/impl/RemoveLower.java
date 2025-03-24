package ru.itmo.tofutogot.command.impl;

import ru.itmo.tofutogot.command.Command;
import ru.itmo.tofutogot.manager.CollectionManager;
import ru.itmo.tofutogot.model.SpaceMarine;
import ru.itmo.tofutogot.util.CommandScanner;

// Удаляет элементы со значениями id меньше чем у заданного элемента

public class RemoveLower extends Command {
    private final CollectionManager collectionManager;
    private final CommandScanner scanner;

    public RemoveLower(CollectionManager collectionManager, CommandScanner scanner) {
        super("remove_lower");
        this.collectionManager = collectionManager;
        this.scanner = scanner;
    }

    @Override
    public void execute(String[] args) {
        try {
            long id = collectionManager.generateId();
            SpaceMarine reference = scanner.readSpaceMarine(id);

            int initialSize = collectionManager.getCollection().size();
            collectionManager.getCollection().removeIf(marine -> marine.compareTo(reference) < 0);
            int removed = initialSize - collectionManager.getCollection().size();

            System.out.println("Удалено элементов: " + removed);
        } catch (Exception e) {
            System.out.println("Ошибка при удалении элементов: " + e.getMessage());
        }
    }

    @Override
    public String getHelp() {
        return "remove_lower - удалить из коллекции все элементы, меньшие, чем заданный";
    }
}

