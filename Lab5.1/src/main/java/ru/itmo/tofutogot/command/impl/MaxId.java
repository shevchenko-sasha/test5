package ru.itmo.tofutogot.command.impl;

import ru.itmo.tofutogot.command.Command;
import ru.itmo.tofutogot.manager.CollectionManager;
import ru.itmo.tofutogot.model.SpaceMarine;

import java.util.Comparator;
import java.util.Optional;

// Выводит элемент коллекции с максимальным значением поля id.

public class MaxId extends Command {
    private final CollectionManager collectionManager;

    public MaxId(CollectionManager collectionManager) {
        super("max_id");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        Optional<SpaceMarine> maxMarine = collectionManager.getCollection().stream()
                .max(Comparator.comparingLong(SpaceMarine::getId));

        if (maxMarine.isPresent()) {
            System.out.println("Элемент с максимальным id:");
            System.out.println(maxMarine.get());
        } else {
            System.out.println("Коллекция пуста.");
        }
    }

    @Override
    public String getHelp() {
        return "max_id - вывести объект с максимальным значением id";
    }
}
