package com.cleverdeveloper.petclinicapp.repositories;

/*
PROJECT NAME : pet-clinic-app
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 12/23/2021 1:09 PM
*/

import com.cleverdeveloper.petclinicapp.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
