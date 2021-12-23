package com.cleverdeveloper.petclinicapp.services.springdatajpa;

/*
PROJECT NAME : pet-clinic-app
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 12/23/2021 1:26 PM
*/

import com.cleverdeveloper.petclinicapp.model.Vet;
import com.cleverdeveloper.petclinicapp.repositories.VetRepository;
import com.cleverdeveloper.petclinicapp.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

// Vet Spring DATA JPA SERVICE
@Service
@Profile("springdatajpa")
public class VetSDJPAService implements VetService {

    private final VetRepository vetRepository;

    public VetSDJPAService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }


    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets =  new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long id) {
        return vetRepository.findById(id).orElse(null);
    }

    @Override
    public Vet save(Vet item) {
        return vetRepository.save(item);
    }

    @Override
    public void delete(Vet item) {
        vetRepository.delete(item);
    }

    @Override
    public void deleteById(Long id) {
        vetRepository.deleteById(id);
    }
}
