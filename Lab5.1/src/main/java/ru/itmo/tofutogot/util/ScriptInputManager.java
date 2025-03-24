package ru.itmo.tofutogot.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Реализация InputManager, читающая строки из файла

public class ScriptInputManager implements InputManager {
    private final Scanner scanner;
    private final String source;

    public ScriptInputManager(File file) throws FileNotFoundException {
        this.scanner = new Scanner(file);
        this.source = file.getAbsolutePath();
    }

    @Override
    public String nextLine() {
        if (scanner.hasNextLine()) {
            return scanner.nextLine();
        }
        throw new RuntimeException("Скрипт завершён: " + source);
    }

    public String getSource() {
        return source;
    }
}
