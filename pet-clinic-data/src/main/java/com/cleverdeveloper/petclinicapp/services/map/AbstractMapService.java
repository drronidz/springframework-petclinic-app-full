package com.cleverdeveloper.petclinicapp.services.map;

/*
PROJECT NAME : pet-clinic-app
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 12/21/2021 9:35 PM
*/

import com.cleverdeveloper.petclinicapp.model.BaseEntity;

import java.util.*;


public abstract class AbstractMapService <T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(T item) {
        if (item != null) {
            if (item.getId() == null) {
                item.setId(getNextId());
            }

            map.put(item.getId(), item);
        }
        else {
            throw new RuntimeException("Item cannot be null");
        }

        return item;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T item) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(item));
    }

    private Long getNextId() {
        Long nextId = null;

        try {
            nextId = Collections.max(map.keySet()) + 1;
        }
        catch (NullPointerException | NoSuchElementException e) {
            nextId = 1L;
        }

        return nextId;
    }
}
