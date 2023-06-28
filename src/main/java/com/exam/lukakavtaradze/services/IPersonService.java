package com.exam.lukakavtaradze.services;

import com.exam.lukakavtaradze.dtos.ApiResponse;
import com.exam.lukakavtaradze.dtos.PersonDto;

import java.time.Period;

public interface IPersonService {
    ApiResponse add(PersonDto dto);

    ApiResponse delete(Long id);

    ApiResponse edit(Long id, PersonDto person);

    ApiResponse getAll();

    ApiResponse getById(Long id);
}
