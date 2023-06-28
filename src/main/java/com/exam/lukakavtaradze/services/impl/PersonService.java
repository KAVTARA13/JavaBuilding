package com.exam.lukakavtaradze.services.impl;

import com.exam.lukakavtaradze.apiUtil.IncorrectParameterException;
import com.exam.lukakavtaradze.dtos.ApiResponse;
import com.exam.lukakavtaradze.dtos.BuildingDto;
import com.exam.lukakavtaradze.dtos.PersonDto;
import com.exam.lukakavtaradze.entities.Building;
import com.exam.lukakavtaradze.entities.Person;
import com.exam.lukakavtaradze.entities.RecordState;
import com.exam.lukakavtaradze.repositories.PersonRepository;
import com.exam.lukakavtaradze.services.IBuildingService;
import com.exam.lukakavtaradze.services.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements IPersonService {

    private final PersonRepository personRepository;
    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @Override
    public ApiResponse add(PersonDto dto) {
        if (dto == null){
            throw new IncorrectParameterException("personDto");
        }
        Person person = new Person(dto);
        person.setRecordState(RecordState.ACTIVE);
        return new ApiResponse("status",this.personRepository.save(person));
    }

    @Override
    public ApiResponse delete(Long id) {
        if(id==null || id <= 0){
            return new ApiResponse().addError("id", "incorrect value");
        }
        Person person = this.personRepository.getById(id);
        person.setRecordState(RecordState.INACTIVE);
        this.personRepository.save(person);
        return new ApiResponse("person",person);
    }

    @Override
    public ApiResponse edit(Long id, PersonDto dto) {
        if (id == null || id <= 0){
            return new ApiResponse().addError("id","incorrect value");
        }
        if (dto != null){
            Person newPerson = this.personRepository.getById(id);
            newPerson.setName(dto.getName());
            return new ApiResponse("person",this.personRepository.save(newPerson));
        }
        return new ApiResponse().addError("INCORRECT_PARAM", "INCORRECT_PARAM");
    }

    @Override
    public ApiResponse getAll() {
        return new ApiResponse("persons",personRepository.getAll());
    }

    @Override
    public ApiResponse getById(Long id) {
        return new ApiResponse("person",personRepository.getById(id));
    }
}
