package ru.itmo.tofutogot.command.impl;
import ru.itmo.tofutogot.command.Command;
import ru.itmo.tofutogot.manager.CommandManager;

// Выводит справку по доступным командам

public class Help extends Command {
    private final CommandManager commandManager;

    public Help(CommandManager commandManager) {
        super("help");
        this.commandManager = commandManager;
    }

    @Override
    public void execute(String[] args) {
        for (Command command : commandManager.getCommands().values()) {
            System.out.println(command.getHelp());
        }
    }

    @Override
    public String getHelp() {
        return "help - вывести справку по доступным командам";
    }
}

