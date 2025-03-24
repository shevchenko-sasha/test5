package ru.itmo.tofutogot;

import ru.itmo.tofutogot.command.impl.*;
import ru.itmo.tofutogot.manager.CollectionManager;
import ru.itmo.tofutogot.manager.CommandManager;
import ru.itmo.tofutogot.util.CommandScanner;
import ru.itmo.tofutogot.util.ConsoleInputManager;
import ru.itmo.tofutogot.util.InputManager;

public class Main {
    public static void main(String[] args) {
        InputManager input = new ConsoleInputManager();
        CommandScanner scanner = new CommandScanner(input);
        CollectionManager collectionManager = new CollectionManager();
        CommandManager commandManager = new CommandManager();

        commandManager.registerCommand(new Add(collectionManager, scanner));
        commandManager.registerCommand(new Help(commandManager));
        commandManager.registerCommand(new Show(collectionManager));
        commandManager.registerCommand(new Info(collectionManager));
        commandManager.registerCommand(new Exit());
        commandManager.registerCommand(new Clear(collectionManager));
        commandManager.registerCommand(new RemoveById(collectionManager));
        commandManager.registerCommand(new Update(collectionManager, scanner));
        commandManager.registerCommand(new RemoveLower(collectionManager, scanner));
        commandManager.registerCommand(new Reorder(collectionManager));
        commandManager.registerCommand(new Generate(collectionManager));
        commandManager.registerCommand(new Sort(collectionManager));
        commandManager.registerCommand(new MaxId(collectionManager));
        commandManager.registerCommand(new FBHC(collectionManager));
        commandManager.registerCommand(new PUCh(collectionManager));

        System.out.println("Введите команду (help для списка):");
        while (true) {
            System.out.print("> ");
            String line = input.nextLine().trim();
            if (line.isBlank()) continue;

            String[] parts = line.split(" ");
            String name = parts[0];
            String[] commandArgs = new String[parts.length - 1];
            System.arraycopy(parts, 1, commandArgs, 0, parts.length - 1);

            commandManager.executeCommand(name, commandArgs);
        }
    }
}
