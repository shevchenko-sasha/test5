package ru.itmo.tofutogot.manager;

import ru.itmo.tofutogot.command.Command;

import java.util.HashMap;
import java.util.Map;

//Менеджер команд. Регистрирует команды и выполняет их по имени

public class CommandManager {
    private final Map<String, Command> commands = new HashMap<>();

    /**
     * Регистрирует команду по имени.
     *
     * @param command команда, реализующая интерфейс Command
     */

    public void registerCommand(Command command) {
        commands.put(command.getName(), command);
    }

    /**
     * Выполняет команду по имени и аргументам
     * @param name имя команды
     * @param args аргументы команды
     */

    public void executeCommand(String name, String[] args) {
        Command command = commands.get(name);
        if (command != null) {
            command.execute(args);
        } else {
            System.out.println("Команда не найдена: " + name);
        }
    }

    /**
     * Возвращает список всех команд (нужно для help).
     * @return Map с командами
     */

    public Map<String, Command> getCommands() {
        return commands;
    }
}

