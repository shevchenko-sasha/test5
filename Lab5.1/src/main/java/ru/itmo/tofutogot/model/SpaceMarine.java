package ru.itmo.tofutogot.model;

import java.time.LocalDateTime;

//Космический десантник — основной элемент коллекции.

public class SpaceMarine implements Comparable<SpaceMarine> {
    private final long id;
    private final LocalDateTime creationDate;

    private String name;
    private Coordinates coordinates;
    private int health;
    private int heartCount;
    private Long height;
    private MeleeWeapon meleeWeapon;
    private Chapter chapter;

    public SpaceMarine(long id, String name, Coordinates coordinates, int health, int heartCount,
                       Long height, MeleeWeapon meleeWeapon, Chapter chapter) {
        if (id <= 0) throw new IllegalArgumentException("ID должен быть больше 0");
        this.id = id;
        this.creationDate = LocalDateTime.now();

        setName(name);
        setCoordinates(coordinates);
        setHealth(health);
        setHeartCount(heartCount);
        setHeight(height);
        setMeleeWeapon(meleeWeapon);
        setChapter(chapter);
    }

    public long getId() {

        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public int getHealth() {
        return health;
    }

    public int getHeartCount() {
        return heartCount;
    }

    public Long getHeight() {
        return height;
    }

    public MeleeWeapon getMeleeWeapon() {
        return meleeWeapon;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть null или пустым.");
        }
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        if (coordinates == null) {
            throw new IllegalArgumentException("Координаты не могут быть null.");
        }
        this.coordinates = coordinates;
    }

    public void setHealth(int health) {
        if (health <= 0) {
            throw new IllegalArgumentException("Здоровье должно быть больше 0.");
        }
        this.health = health;
    }

    public void setHeartCount(int heartCount) {
        if (heartCount <= 0 || heartCount > 3) {
            throw new IllegalArgumentException("Количество сердец должно быть от 1 до 3.");
        }
        this.heartCount = heartCount;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    public void setMeleeWeapon(MeleeWeapon meleeWeapon) {
        this.meleeWeapon = meleeWeapon;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    @Override
    public int compareTo(SpaceMarine other) {
        return Long.compare(this.id, other.id);
    }

    @Override
    public String toString() {
        return "SpaceMarine{" +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", coordinates = " + coordinates +
                ", creationDate = " + creationDate +
                ", health = " + health +
                ", heartCount = " + heartCount +
                ", height = " + height +
                ", meleeWeapon = " + meleeWeapon +
                ", chapter = " + chapter +
                '}';
    }
}
