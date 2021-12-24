package com.cleverdeveloper.petclinicapp.model;

/*
PROJECT NAME : pet-clinic-app
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 12/21/2021 2:08 PM
*/

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.security.PublicKey;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
@Table(name = "owner")
public class Owner extends Person{

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "phone")
    private String phone;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    @Builder.Default
    private Set<Pet> pets = new HashSet<>();

    /*
    * Return the Pet with the given name, or null if none found for this owner
    * @param name to test
    * @return true if pet name is already in use
    * */
    public Pet getPet(String name) {
        return getPet(name, false);
    }

    /*
    * Return the Pet with the given name, or null if none found for this Owner.
     * @param name to test
     * @return true if pet name is already in use
     * */
    public Pet getPet(String name, boolean ignoreNew) {
        name = name.toLowerCase();
        for (Pet pet : pets) {
            if (!ignoreNew || !pet.isNew()) {
                String compName = pet.getName();
                compName = compName.toLowerCase();
                if (compName.equals(name)) {
                    return pet;
                }
            }
        }
        return null;
    }

//    public Set<Pet> getPets() {
//        if (pets == null) {
//            return new HashSet<Pet>();
//        }
//        return pets;
//    }
//
//    public void setPets(Set<Pet> pets) {
//        this.pets = pets;
//    }
}
