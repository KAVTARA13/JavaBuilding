package com.exam.lukakavtaradze.entities;

import com.exam.lukakavtaradze.dtos.PersonDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "PERSON")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Person extends BaseEntity<Long> {
    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "personIdSeq", sequenceName = "PERSON_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "personIdSeq")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    public Person(PersonDto dto){
        this.name = dto.getName();
    }

}
