package com.exam.lukakavtaradze.entities;

import com.exam.lukakavtaradze.dtos.BuildingDto;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "BUILDING")
public class Building extends BaseEntity<Long>{
    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "buildingIdSeq", sequenceName = "BUILDING_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "buildingIdSeq")
    private Long id;

    @Column(name = "ADDRESS", nullable = false)
    private String address;

    public Building(BuildingDto dto){
        this.address = dto.getAddress();
    }

    @ManyToOne
    private Person person;
}
