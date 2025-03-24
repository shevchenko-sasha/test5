package ru.itmo.tofutogot.command.impl;

import ru.itmo.tofutogot.command.Command;

// Выход из программы

public class Exit extends Command {

    public Exit() {
        super("exit");
    }

    @Override
    public void execute(String[] args) {
        System.out.println("Завершение программы...");
        System.exit(0);
    }

    @Override
    public String getHelp() {
        return "exit - завершить программу (без сохранения)";
    }
}

