package com.cleverdeveloper.petclinicapp.services.map;

/*
PROJECT NAME : pet-clinic-app
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 12/21/2021 9:41 PM
*/

import com.cleverdeveloper.petclinicapp.model.Owner;
import com.cleverdeveloper.petclinicapp.services.CrudService;
import com.cleverdeveloper.petclinicapp.services.OwnerService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner item) {
        super.delete(item);
    }

    @Override
    public Owner save(Owner item) {
        return super.save(item);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }
}
