package org.springframework.samples.petclinic.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.PetType;
import org.springframework.samples.petclinic.repository.OwnerRepository;
import org.springframework.samples.petclinic.repository.PetRepository;
import org.springframework.samples.petclinic.repository.VetRepository;
import org.springframework.samples.petclinic.repository.VisitRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class ClinicServiceImplTest {

    @Mock
    PetRepository petRepository;
    @Mock
    VetRepository vetRepository;
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    VisitRepository visitRepository;

    @InjectMocks
    ClinicServiceImpl clinicService;

    @Test
    void findPetTypes() {
        //given
        PetType type1 = new PetType();
        type1.setName("dog");
        PetType type2 = new PetType();
        type2.setName("cat");
        PetType type3 = new PetType();
        type3.setName("turtle");

        List<PetType> types = new ArrayList<>();
        types.add(type1);
        types.add(type2);
        types.add(type3);

        given(petRepository.findPetTypes()).willReturn(types);

        //when
        Collection<PetType> returnedTypes = clinicService.findPetTypes();

        //then
        assertThat(returnedTypes.size()).isEqualTo(types.size());
    }
}