package com.cleverdeveloper.petclinicapp.services;

/*
PROJECT NAME : pet-clinic-app
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 12/21/2021 2:16 PM
*/

import com.cleverdeveloper.petclinicapp.model.Owner;

import java.util.List;


public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
    List<Owner> findAllByLastNameLike(String lastName);
}
