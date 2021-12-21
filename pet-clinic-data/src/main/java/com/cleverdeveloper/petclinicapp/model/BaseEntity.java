package com.cleverdeveloper.petclinicapp.model;

/*
PROJECT NAME : pet-clinic-app
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 12/21/2021 2:24 PM
*/

import java.io.Serializable;

public class BaseEntity implements Serializable {

    // This is a baseEntity for global items ...
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
