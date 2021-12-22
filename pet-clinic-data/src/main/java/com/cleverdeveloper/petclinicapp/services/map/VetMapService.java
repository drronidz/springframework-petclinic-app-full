package com.cleverdeveloper.petclinicapp.services.map;

/*
PROJECT NAME : pet-clinic-app
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 12/21/2021 9:45 PM
*/

import com.cleverdeveloper.petclinicapp.model.Specialty;
import com.cleverdeveloper.petclinicapp.model.Vet;
import com.cleverdeveloper.petclinicapp.services.SpecialtyService;
import com.cleverdeveloper.petclinicapp.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialtyService specialtyService;

    public VetMapService(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }


    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet item) {
        super.delete(item);
    }

    @Override
    public Vet save(Vet item) {
        if (item.getSpecialties().size() > 0) {
            item.getSpecialties().forEach(specialty -> {
                if (specialty.getId() == null) {
                    Specialty savedSpecialty = specialtyService.save(specialty);
                    specialty.setId(savedSpecialty.getId());
                }
            });
        }
        return super.save(item);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
