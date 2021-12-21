package com.cleverdeveloper.petclinicapp.services;

/*
PROJECT NAME : pet-clinic-app
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 12/21/2021 9:27 PM
*/

import java.util.Set;

public interface CrudService <T, ID> {

    Set<T> findAll();

    T findById(ID id);

    T save(T item);

    void delete (T item);

    void deleteById(ID id);

}
