package com.cleverdeveloper.petclinicapp.controllers;

import com.cleverdeveloper.petclinicapp.model.Owner;
import com.cleverdeveloper.petclinicapp.model.Pet;
import com.cleverdeveloper.petclinicapp.model.PetType;
import com.cleverdeveloper.petclinicapp.services.OwnerService;
import com.cleverdeveloper.petclinicapp.services.PetService;
import com.cleverdeveloper.petclinicapp.services.PetTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/*
PROJECT NAME : pet-clinic-app
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 12/24/2021 10:08 PM
*/
@Controller
@RequestMapping("/owners/{ownerId}")
public class PetController {

    private static final String VIEWS_PETS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm";

    private final PetService petService;
    private final OwnerService ownerService;
    private final PetTypeService petTypeService;

    public PetController(PetService petService, OwnerService ownerService, PetTypeService petTypeService) {
        this.petService = petService;
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
    }

    @ModelAttribute("petTypes")
    public Collection<PetType> populatePetTypes() {
        return petTypeService.findAll();
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable("ownerId") Long ownerId) {
        return ownerService.findById(ownerId);
    }

    @InitBinder("owner")
    public void initOwnerBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping("/pets/new")
    public String initCreationForm(Owner owner, Model model) {
        Pet pet = new Pet();
        owner.getPets().add(pet);
        pet.setOwner(owner); // Giving the pet an Owner (Dependency Injection Pet->Owner)
        model.addAttribute("pet", pet);
        return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/pets/new")
    public String processCreationForm(Owner owner, @Valid Pet pet, BindingResult result, Model model) {
        if (StringUtils.hasLength(pet.getName()) && pet.isNew() && owner.getPet(pet.getName(), true) != null) {
            result.rejectValue("name", "duplicate", "already exists");
        }

//        owner.getPets().add(pet); // Giving the owner a pet (Dependency Injection Owner-Pet)
//        pet.setOwner(owner); // Giving the pet an Owner (Dependency Injection Pet->Owner)

        if (result.hasErrors()) {
            model.addAttribute("pet", pet);
            return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
        }
        else {

            petService.save(pet);
            return "redirect:/owners/" + owner.getId();
        }
    }
}