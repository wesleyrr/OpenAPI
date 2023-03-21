package com.company.bff.swagger.controller;

import com.company.bff.swagger.api.PetApi;
import com.company.bff.swagger.domain.Category;
import com.company.bff.swagger.domain.Pet;
import com.company.bff.swagger.domain.Tag;
import java.util.Arrays;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PetControllerApi implements PetApi {

  @Override
  public ResponseEntity<Pet> getPetById(Long petId) {

    Pet cacau = Pet.builder()
        .id(1l)
        .name("Cacau")
        .category(Category.builder().name("Dogs").id(1l) .build())
        .tags(Arrays.asList(Tag.builder().id(1l).name("filtroqualquer").build()))
        .status(Pet.StatusEnum.AVAILABLE)
        .build();

    return ResponseEntity.ok(cacau);
  }
}
