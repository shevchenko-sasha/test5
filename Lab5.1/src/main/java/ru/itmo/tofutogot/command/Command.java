package ru.itmo.tofutogot.command;

// Абстрактный класс для всех команд

public abstract class Command {
    private final String name;

    protected Command(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * @param args аргументы, переданные пользователем
     */

    public abstract void execute(String[] args);

    public abstract String getHelp();
}
