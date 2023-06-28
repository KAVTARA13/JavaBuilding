package com.exam.lukakavtaradze.services.impl;

import com.exam.lukakavtaradze.dtos.ApiResponse;
import com.exam.lukakavtaradze.dtos.BuildingDto;
import com.exam.lukakavtaradze.entities.Building;
import com.exam.lukakavtaradze.repositories.BuildingRepository;
import com.exam.lukakavtaradze.repositories.PersonRepository;
import com.exam.lukakavtaradze.services.IBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuildingService implements IBuildingService {
    private final BuildingRepository buildingRepository;
    private final PersonRepository personRepository;

    @Autowired
    public BuildingService(BuildingRepository buildingRepository, PersonRepository personRepository) {
        this.buildingRepository = buildingRepository;
        this.personRepository = personRepository;
    }

    @Override
    public ApiResponse add(BuildingDto dto) {
        if (dto == null){
            return new ApiResponse().addError("INCORRECT_PARAM","BUILDING_DTO_IS_NULL");
        }
        Building building = new Building();
        building.setAddress(dto.getAddress());
        building.setPerson(personRepository.getById(dto.getPersonId()));
        return new ApiResponse("status",this.buildingRepository.save(building));
    }

    @Override
    public ApiResponse delete(Long id) {
        if(id==null || id <= 0){
            return new ApiResponse().addError("id", "incorrect value");
        }
        Building building = this.buildingRepository.getById(id);
        this.buildingRepository.delete(building);
        return new ApiResponse("department",building);
    }

    @Override
    public ApiResponse edit(Long id, BuildingDto dto) {
        if (id == null || id <= 0){
            return new ApiResponse().addError("id","incorrect value");
        }
        if (dto != null){
            Building newBuilding = this.buildingRepository.getById(id);
            newBuilding.setAddress(dto.getAddress());
            return new ApiResponse("building",this.buildingRepository.save(newBuilding));
        }
        return new ApiResponse().addError("INCORRECT_PARAM", "INCORRECT_PARAM");
    }

    @Override
    public ApiResponse getAll() {
        return new ApiResponse("departments",buildingRepository.getAll());
    }

    @Override
    public ApiResponse getById(Long id) {
        return new ApiResponse("departments",buildingRepository.getById(id));
    }

}
