package com.cleverdeveloper.petclinicapp.services.springdatajpa;

/*
PROJECT NAME : pet-clinic-app
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 12/23/2021 1:36 PM
*/

import com.cleverdeveloper.petclinicapp.model.Pet;
import com.cleverdeveloper.petclinicapp.model.PetType;
import com.cleverdeveloper.petclinicapp.repositories.PetRepository;
import com.cleverdeveloper.petclinicapp.services.PetService;
import com.cleverdeveloper.petclinicapp.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

// Pet Spring DATA JPA SERVICE
@Service
@Profile("springdatajpa")
public class PetSDJPAService implements PetService {

    private final PetRepository petRepository;

    public PetSDJPAService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findById(Long id) {
        return petRepository.findById(id).orElse(null);
    }

    @Override
    public Pet save(Pet item) {
        return petRepository.save(item);
    }

    @Override
    public void delete(Pet item) {
        petRepository.delete(item);
    }

    @Override
    public void deleteById(Long id) {
        petRepository.deleteById(id);
    }
}
