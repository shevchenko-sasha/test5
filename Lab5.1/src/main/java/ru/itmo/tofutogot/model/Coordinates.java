package ru.itmo.tofutogot.model;

/**
 * Класс, представляющий координаты SpaceMarine.
 */

public class Coordinates {
    private int x;
    private float y; // Максимальное значение: 876

    /**
     * Конструктор координат.
     *
     * @param x координата X (любое целое число)
     * @param y координата Y (не больше 876)
     */
    public Coordinates(int x, float y) {
        this.setX(x);
        this.setY(y);
    }

    // === Getters ===

    public int getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    // === Setters (с валидацией) ===

    public void setX(int x) {
        this.x = x;
    }

    public void setY(float y) {
        if (y > 876) {
            throw new IllegalArgumentException("Координата Y не может быть больше 876.");
        }
        this.y = y;
    }

    // === toString (для вывода) ===

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}