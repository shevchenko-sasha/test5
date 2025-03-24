package ru.itmo.tofutogot.command.impl;

import ru.itmo.tofutogot.command.Command;
import ru.itmo.tofutogot.manager.CollectionManager;
import ru.itmo.tofutogot.model.SpaceMarine;
import ru.itmo.tofutogot.util.CommandScanner;

// Меняет значения элемента с указанным id

public class Update extends Command {
    private final CollectionManager collectionManager;
    private final CommandScanner scanner;

    public Update(CollectionManager collectionManager, CommandScanner scanner) {
        super("update");
        this.collectionManager = collectionManager;
        this.scanner = scanner;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 1) {
            System.out.println("Использование: update <id>");
            return;
        }

        try {
            long id = Long.parseLong(args[0]);

            if (!collectionManager.existsById(id)) {
                System.out.println("Элемент с таким id не найден.");
                return;
            }

            SpaceMarine updated = scanner.readSpaceMarine(id);
            collectionManager.updateById(id, updated);
            System.out.println("Элемент с id " + id + " успешно обновлён.");
        } catch (NumberFormatException e) {
            System.out.println("Некорректный формат id.");
        } catch (Exception e) {
            System.out.println("Ошибка при обновлении элемента: " + e.getMessage());
        }
    }

    @Override
    public String getHelp() {
        return "update <id> - обновить элемент по id";
    }
}
