package com.cleverdeveloper.petclinicapp.bootstrap;

/*
PROJECT NAME : pet-clinic-app
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 12/21/2021 10:39 PM
*/

import com.cleverdeveloper.petclinicapp.model.*;
import com.cleverdeveloper.petclinicapp.services.OwnerService;
import com.cleverdeveloper.petclinicapp.services.PetTypeService;
import com.cleverdeveloper.petclinicapp.services.SpecialtyService;
import com.cleverdeveloper.petclinicapp.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }


    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType toSaveDog = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType toSaveCat = petTypeService.save(cat);

        System.out.println("Loaded PetTypes ...");

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty toSaveRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty toSaveSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty toSaveDentistry = specialtyService.save(dentistry);

        Owner ownerOne = new Owner();
        ownerOne.setFirstName("Tom");
        ownerOne.setLastName("Hardy");
        ownerOne.setAddress("Wall Street");
        ownerOne.setCity("New York");
        ownerOne.setPhone("0779616727");

        Pet tomsPet = new Pet();
        tomsPet.setPetType(toSaveCat);
        tomsPet.setOwner(ownerOne);
        tomsPet.setBirthDate(LocalDate.now());
        tomsPet.setName("Baguira");
        ownerOne.getPets().add(tomsPet);

        ownerService.save(ownerOne);

        Owner ownerTwo = new Owner();
        ownerTwo.setFirstName("Jeff");
        ownerTwo.setLastName("Robinson");
        ownerTwo.setAddress("Banshee");
        ownerTwo.setCity("Pennsylvania");
        ownerTwo.setPhone("0559445022");

        Pet jeffsPet = new Pet();
        jeffsPet.setPetType(toSaveDog);
        jeffsPet.setOwner(ownerTwo);
        jeffsPet.setBirthDate(LocalDate.now());
        jeffsPet.setName("Rosco");
        ownerTwo.getPets().add(jeffsPet);

        ownerService.save(ownerTwo);

        Owner ownerThree = new Owner();
        ownerThree.setFirstName("Jason");
        ownerThree.setLastName("Drake");
        ownerService.save(ownerThree);

        System.out.println("Loaded Owners ...");

        Vet vetOne = new Vet();
        vetOne.setFirstName("John");
        vetOne.setLastName("Thompson");
        vetOne.getSpecialties().add(toSaveRadiology);
        vetOne.getSpecialties().add(toSaveDentistry);
        vetService.save(vetOne);

        Vet vetTwo = new Vet();
        vetTwo.setFirstName("Jane");
        vetTwo.setLastName("Rooney");
        vetTwo.getSpecialties().add(toSaveRadiology);
        vetTwo.getSpecialties().add(toSaveSurgery);
        vetService.save(vetTwo);

        System.out.println("Loaded Vets ...");


    }
}
