package ru.itmo.tofutogot.manager;

import ru.itmo.tofutogot.model.SpaceMarine;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.Vector;

//Класс для управления коллекцией объектов SpaceMarine

public class CollectionManager {
    private final Vector<SpaceMarine> collection = new Vector<>();
    private final Set<Long> usedIds = new HashSet<>();
    private final Random random = new Random();
    private final LocalDateTime initializationDate = LocalDateTime.now();

    public long generateId() {
        long id;
        do {
            id = 1_000_000_000L + Math.abs(random.nextLong() % 9_000_000_000L); // 10-значный id
        } while (usedIds.contains(id));
        usedIds.add(id);
        return id;
    }

    public LocalDateTime getInitializationDate() {
        return initializationDate;
    }

    public void add(SpaceMarine marine) {
        collection.add(marine);
        usedIds.add(marine.getId()); // на случай загрузки из файла
    }

    public boolean removeById(long id) {
        return collection.removeIf(marine -> marine.getId() == id);
    }

    public boolean existsById(long id) {
        return collection.stream().anyMatch(marine -> marine.getId() == id);
    }

    public void updateById(long id, SpaceMarine newMarine) {
        for (int i = 0; i < collection.size(); i++) {
            if (collection.get(i).getId() == id) {
                collection.set(i, newMarine);
                return;
            }
        }
    }

    public Vector<SpaceMarine> getCollection() {
        return collection;
    }
}
