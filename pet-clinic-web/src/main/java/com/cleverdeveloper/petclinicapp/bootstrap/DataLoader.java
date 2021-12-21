package com.cleverdeveloper.petclinicapp.bootstrap;

/*
PROJECT NAME : pet-clinic-app
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 12/21/2021 10:39 PM
*/

import com.cleverdeveloper.petclinicapp.model.Owner;
import com.cleverdeveloper.petclinicapp.model.Pet;
import com.cleverdeveloper.petclinicapp.model.Vet;
import com.cleverdeveloper.petclinicapp.services.OwnerService;
import com.cleverdeveloper.petclinicapp.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }


    @Override
    public void run(String... args) throws Exception {

        Owner ownerOne = new Owner();
        ownerOne.setFirstName("Tom");
        ownerOne.setLastName("Hardy");
        ownerService.save(ownerOne);

        Owner ownerTwo = new Owner();
        ownerTwo.setFirstName("Jeff");
        ownerTwo.setLastName("Robinson");
        ownerService.save(ownerTwo);

        Owner ownerThree = new Owner();
        ownerThree.setFirstName("Jason");
        ownerThree.setLastName("Drake");
        ownerService.save(ownerThree);

        System.out.println("Loaded Owners ...");

        Vet vetOne = new Vet();
        vetOne.setFirstName("John");
        vetOne.setLastName("Thompson");
        vetService.save(vetOne);

        Vet vetTwo = new Vet();
        vetTwo.setFirstName("Jane");
        vetTwo.setLastName("Rooney");
        vetService.save(vetTwo);

        System.out.println("Loaded Vets ...");


    }
}
