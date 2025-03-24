package ru.itmo.tofutogot.command.impl;

import ru.itmo.tofutogot.command.Command;
import ru.itmo.tofutogot.manager.CollectionManager;

// Удаляет элемент с указанным id

public class RemoveById extends Command {
    private final CollectionManager collectionManager;

    public RemoveById(CollectionManager collectionManager) {
        super("remove_id");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        if (args.length < 1) {
            System.out.println("Ошибка: укажите id для удаления. Пример: remove_by_id 3");
            return;
        }

        try {
            long id = Long.parseLong(args[0]);
            boolean removed = collectionManager.removeById(id);
            if (removed) {
                System.out.println("Элемент с id " + id + " успешно удалён.");
            } else {
                System.out.println("Элемент с id " + id + " не найден.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: id должен быть числом.");
        }
    }

    @Override
    public String getHelp() {
        return "remove_id №id - удалить элемент из коллекции по его id";
    }
}

