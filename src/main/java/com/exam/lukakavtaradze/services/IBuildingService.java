package com.exam.lukakavtaradze.services;

import com.exam.lukakavtaradze.dtos.ApiResponse;
import com.exam.lukakavtaradze.dtos.BuildingDto;

public interface IBuildingService {
    ApiResponse add(BuildingDto dto);

    ApiResponse delete(Long id);

    ApiResponse edit(Long id, BuildingDto departmentDto);

    ApiResponse getAll();

    ApiResponse getById(Long id);


}
