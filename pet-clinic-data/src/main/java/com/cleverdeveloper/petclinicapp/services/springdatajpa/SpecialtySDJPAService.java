package com.cleverdeveloper.petclinicapp.services.springdatajpa;

/*
PROJECT NAME : pet-clinic-app
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 12/23/2021 1:47 PM
*/

import com.cleverdeveloper.petclinicapp.model.Specialty;
import com.cleverdeveloper.petclinicapp.repositories.SpecialtyRepository;
import com.cleverdeveloper.petclinicapp.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

// Specialty Spring DATA JPA SERVICE
@Service
@Profile("springdatajpa")
public class SpecialtySDJPAService implements SpecialtyService {

    private final SpecialtyRepository specialtyRepository;

    public SpecialtySDJPAService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Set<Specialty> findAll() {
        Set<Specialty> specialties = new HashSet<>();
        specialtyRepository.findAll().forEach(specialties::add);
        return specialties;
    }

    @Override
    public Specialty findById(Long id) {
        return specialtyRepository.findById(id).orElse(null);
    }

    @Override
    public Specialty save(Specialty item) {
        return specialtyRepository.save(item);
    }

    @Override
    public void delete(Specialty item) {
        specialtyRepository.delete(item);
    }

    @Override
    public void deleteById(Long id) {
        specialtyRepository.deleteById(id);
    }
}
