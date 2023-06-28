package com.exam.lukakavtaradze.controllers;

import com.exam.lukakavtaradze.dtos.ApiResponse;
import com.exam.lukakavtaradze.dtos.BuildingDto;
import com.exam.lukakavtaradze.services.IBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/building")
public class BuildingController {
    private final IBuildingService buildingService;
    @Autowired
    public BuildingController(IBuildingService buildingService) {
        this.buildingService = buildingService;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ApiResponse addBuilding(@RequestBody BuildingDto dto){
        return this.buildingService.add(dto);
    }
    @GetMapping(value = "/getAll")
    public ApiResponse getBuildings(){
        return this.buildingService.getAll();
    }
    @DeleteMapping(value = "/delete/{id}")
    public ApiResponse deleteBuilding(@PathVariable Long id){
        return this.buildingService.delete(id);
    }
    @PutMapping(value = "/edit/{id}")
    public ApiResponse editBuilding(@PathVariable Long id,@RequestBody BuildingDto dto){
        return this.buildingService.edit(id, dto);
    }

}
