package ru.itmo.tofutogot.command.impl;

import ru.itmo.tofutogot.command.Command;
import ru.itmo.tofutogot.manager.CollectionManager;
import ru.itmo.tofutogot.model.SpaceMarine;
import ru.itmo.tofutogot.model.Chapter;

import java.util.HashSet;
import java.util.Set;

// Выводит элементы с уникальными значениями отделений

public class PUCh extends Command {
    private final CollectionManager collectionManager;

    public PUCh(CollectionManager collectionManager) {
        super("puch");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        Set<Chapter> uniqueChapters = new HashSet<>();

        for (SpaceMarine marine : collectionManager.getCollection()) {
            Chapter chapter = marine.getChapter();
            if (chapter != null) {
                uniqueChapters.add(chapter);
            }
        }

        if (uniqueChapters.isEmpty()) {
            System.out.println("Уникальных отделений не найдено.");
        } else {
            System.out.println("Уникальные отделения:");
            for (Chapter chapter : uniqueChapters) {
                System.out.println(chapter);
            }
        }
    }

    @Override
    public String getHelp() {
        return "puch - (print unique chapter) вывести уникальные значения поля chapter всех элементов в коллекции";
    }
}

