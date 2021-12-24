package com.cleverdeveloper.petclinicapp.repositories;

/*
PROJECT NAME : pet-clinic-app
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 12/23/2021 1:08 PM
*/

import com.cleverdeveloper.petclinicapp.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Owner findByLastName(String lastName);
    List<Owner> findAllByLastNameLike(String lastName);
}
