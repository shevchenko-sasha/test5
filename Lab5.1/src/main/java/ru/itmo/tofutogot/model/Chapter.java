package ru.itmo.tofutogot.model;

//Отделение (chapter) космического десантника.

public class Chapter {
    private String name;   // не может быть null или пустой
    private String world;  // может быть null

    public Chapter(String name, String world) {
        setName(name);
        setWorld(world);
    }

    public String getName() {
        return name;
    }

    public String getWorld() {
        return world;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя главы не может быть null или пустым.");
        }
        this.name = name;
    }

    public void setWorld(String world) {
        this.world = world; // null допустим
    }

    @Override
    public String toString() {
        return "Chapter{name='" + name + "', world='" + world + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chapter)) return false;
        Chapter other = (Chapter) o;
        return name.equals(other.name) &&
                (world != null ? world.equals(other.world) : other.world == null);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (world != null ? world.hashCode() : 0);
        return result;
    }
}
