package com.exam.lukakavtaradze.controllers;

import com.exam.lukakavtaradze.dtos.ApiResponse;
import com.exam.lukakavtaradze.dtos.BuildingDto;
import com.exam.lukakavtaradze.dtos.PersonDto;
import com.exam.lukakavtaradze.services.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final IPersonService personService;
    @Autowired
    public PersonController(IPersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ApiResponse addPerson(@RequestBody PersonDto dto){
        return this.personService.add(dto);
    }
    @GetMapping(value = "/getAll")
    public ApiResponse getPersons(){
        return this.personService.getAll();
    }
    @DeleteMapping(value = "/delete/{id}")
    public ApiResponse deletePerson(@PathVariable Long id){
        return this.personService.delete(id);
    }
    @PutMapping(value = "/edit/{id}")
    public ApiResponse editPerson(@PathVariable Long id,@RequestBody PersonDto dto){
        return this.personService.edit(id, dto);
    }
}
