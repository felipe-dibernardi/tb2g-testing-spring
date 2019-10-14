package org.springframework.samples.petclinic.web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.model.Vets;
import org.springframework.samples.petclinic.service.ClinicService;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class VetControllerTest {

    private static final String VETS_VET_LIST = "vets/vetList";

    @Mock
    ClinicService clinicService;

    @InjectMocks
    VetController vetController;

    Vets vets;

    @BeforeEach
    void setup() {
        Vet vet1 = new Vet();
        Vet vet2 = new Vet();
        vets = new Vets();
        vets.getVetList().add(vet1);
        vets.getVetList().add(vet2);

        //given
        given(clinicService.findVets()).willReturn(vets.getVetList());
    }

    @Test
    void showVetList() {
        //given
        Map<String, Object> model = new HashMap<>();
        //when
        String viewName = vetController.showVetList(model);

        //then
        then(clinicService).should().findVets();
        assertThat(viewName).isEqualToIgnoringCase(VETS_VET_LIST);
        assertThat(vets.getVetList()).isEqualTo(((Vets) model.get("vets")).getVetList());
    }

    @Test
    void showResourcesVetList() {
        //when
        Vets returnedVets = vetController.showResourcesVetList();

        //then
        assertThat(returnedVets.getVetList()).isEqualTo(vets.getVetList());
    }
}