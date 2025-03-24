package ru.itmo.tofutogot.command.impl;

import ru.itmo.tofutogot.command.Command;
import ru.itmo.tofutogot.manager.CommandManager;
import ru.itmo.tofutogot.util.CommandScanner;

import ru.itmo.tofutogot.util.InputManager;
import ru.itmo.tofutogot.util.ScriptInputManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;

public class ExecuteScript extends Command {
    private final CommandManager commandManager;
    private final CommandScanner commandScanner;
    private final Set<String> activeScripts = new HashSet<>();

    public ExecuteScript(CommandManager commandManager, CommandScanner commandScanner) {
        super("execute_script");
        this.commandManager = commandManager;
        this.commandScanner = commandScanner;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 1) {
            System.out.println("Ошибка: укажите имя файла. Пример: execute_script commands.txt");
            return;
        }

        String fileName = args[0];
        File scriptFile = new File(fileName);

        if (!scriptFile.exists() || !scriptFile.canRead()) {
            System.out.println("Файл не найден или не может быть прочитан: " + fileName);
            return;
        }

        String scriptPath = scriptFile.getAbsolutePath();
        if (activeScripts.contains(scriptPath)) {
            System.out.println("Рекурсия: скрипт уже выполняется: " + scriptPath);
            return;
        }

        try {
            activeScripts.add(scriptPath);
            InputManager oldInput = commandScanner.getInputManager();
            commandScanner.setInputManager(new ScriptInputManager(scriptFile));

            while (true) {
                String line;
                try {
                    line = commandScanner.getInputManager().nextLine().trim();
                } catch (RuntimeException e) {
                    break;
                }

                if (line.isBlank()) continue;

                String[] parts = line.split(" ");
                String commandName = parts[0];
                String[] commandArgs = new String[parts.length - 1];
                System.arraycopy(parts, 1, commandArgs, 0, commandArgs.length);

                commandManager.executeCommand(commandName, commandArgs);
            }

            commandScanner.setInputManager(oldInput);
            activeScripts.remove(scriptPath);
            System.out.println("Скрипт выполнен: " + fileName);

        } catch (FileNotFoundException e) {
            System.out.println("Ошибка при открытии файла: " + e.getMessage());
        }
    }

    @Override
    public String getHelp() {
        return "execute_script <file_name> - выполнить команды из указанного файла";
    }
}
