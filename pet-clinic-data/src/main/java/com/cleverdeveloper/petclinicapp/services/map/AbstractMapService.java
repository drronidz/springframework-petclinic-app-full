package com.cleverdeveloper.petclinicapp.services.map;

/*
PROJECT NAME : pet-clinic-app
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 12/21/2021 9:35 PM
*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService <T, ID> {

    protected Map<ID, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(ID id,T item) {
        map.put(id, item);

        return item;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T item) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(item));
    }
}
