package com.cleverdeveloper.petclinicapp.services.map;

/*
PROJECT NAME : pet-clinic-app
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 12/22/2021 3:54 PM
*/

import com.cleverdeveloper.petclinicapp.model.Specialty;
import com.cleverdeveloper.petclinicapp.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class SpecialtyMapService extends AbstractMapService<Specialty, Long> implements SpecialtyService {
    @Override
    public Set<Specialty> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Specialty item) {
        super.delete(item);
    }

    @Override
    public Specialty save(Specialty item) {
        return super.save(item);
    }

    @Override
    public Specialty findById(Long id) {
        return super.findById(id);
    }
}
