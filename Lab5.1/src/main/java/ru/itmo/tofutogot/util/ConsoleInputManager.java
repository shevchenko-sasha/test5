package ru.itmo.tofutogot.util;

import java.util.Scanner;

//Реализация InputManager, читающая данные из консоли.

public class ConsoleInputManager implements InputManager {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String nextLine() {
        return scanner.nextLine();
    }
}
