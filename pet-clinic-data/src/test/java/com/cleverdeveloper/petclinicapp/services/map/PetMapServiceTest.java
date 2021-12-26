package com.cleverdeveloper.petclinicapp.services.map;

import com.cleverdeveloper.petclinicapp.model.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


/*
PROJECT NAME : pet-clinic-app
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 12/26/2021 3:14 PM
*/

class PetMapServiceTest {

    private PetMapService petMapService;
    private final Long petId = 1L;
    Pet pet;

    @BeforeEach
    void setUp() {
        petMapService = new PetMapService();
        pet = Pet.builder().id(petId).build();
        petMapService.save(pet);
    }

    @Test
    void findAll() {
        Set<Pet> pets = petMapService.findAll();
        assertEquals(1, pets.size());
    }

    @Test
    void deleteById() {
        petMapService.deleteById(petId);
        assertEquals(0, petMapService.findAll().size());
    }

    @Test
    void deleteWithWrongId() {
        Long wrongId = 2L;
        petMapService.deleteById(wrongId);
        assertEquals(1, petMapService.findAll().size());
    }

    @Test
    void deleteWithNullId() {
        petMapService.deleteById(null);
        assertEquals(1, petMapService.findAll().size());
    }
    @Test
    void delete() {
        petMapService.delete(pet);
        assertEquals(0, petMapService.findAll().size());
    }

    @Test
    void deleteWithNullPet(){
        petMapService.delete(null);
        assertEquals(1, petMapService.findAll().size());
    }

    @Test
    void deleteWithWrongPet() {
        Pet wrongPet = Pet.builder().id(5L).build();
        petMapService.delete(wrongPet);
        assertEquals(1, petMapService.findAll().size());
    }

    @Test
    void save() {
        Long toSaveId = 2L;
        Pet pet = Pet.builder().id(toSaveId).build();
        Pet savedPet = petMapService.save(pet);
        assertEquals(toSaveId, savedPet.getId());
    }

    @Test
    void saveWithDuplicatedId() {
        Long toSaveId = 1L;
        Pet pet = Pet.builder().id(toSaveId).build();
        Pet savedPet = petMapService.save(pet);

        assertEquals(toSaveId, savedPet.getId());
        assertEquals(1, petMapService.findAll().size());
    }

    @Test
    void saveWithNoId() {
        Pet savedPet = petMapService.save(Pet.builder().build());
        assertNotNull(savedPet);
        assertNotNull(savedPet.getId());
        assertEquals(2, petMapService.findAll().size());
    }

    @Test
    void findById() {
        Pet pet = petMapService.findById(petId);
        assertEquals(petId, pet.getId());
    }

    @Test
    void findByWrongId() {
        Long wrongId = 5L;
        Pet pet = petMapService.findById(wrongId);
        assertNull(pet, "The pet with id " + wrongId + "does not exit!");
    }

    @Test
    void findByNullId() {
        Long nullId = null;
        Pet pet = petMapService.findById(nullId);
        assertNull(pet, "The pet with id " + nullId + "does not exit!");
    }
}