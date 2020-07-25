package com.social.cycle.service;

import com.social.cycle.repository.ChainAssemblyRepository;
import com.social.cycle.repository.FramesRepository;
import com.social.cycle.repository.HandleBarAndBrakesRepository;
import com.social.cycle.repository.SeatingRepository;
import com.social.cycle.repository.WheelsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCalculatePricing {

    @Mock
    FramesRepository framesRepository;
    @Mock
    ChainAssemblyRepository chainAssemblyRepository;
    @Mock
    HandleBarAndBrakesRepository handleBarAndBrakesRepository;
    @Mock
    SeatingRepository seatingRepository;
    @Mock
    WheelsRepository wheelsRepository;

    @InjectMocks
    CalculatePricing calculatePricing;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void calculate() throws ParseException {
        //dummy epoch value
        long dateForFrames = 1595672413, dateForChainAssemblies = 1595672413, dateForHandleAndBrakes = 1595672413, dateForWheels = 1595672413, dateForSeatings = 1595672413;
        //dummy price
        Double cyclePrice = 25573.0;

        Mockito.when(framesRepository.getFrameInRange(dateForFrames)).thenReturn(25573.0);
        Mockito.when(handleBarAndBrakesRepository.getInRange(dateForHandleAndBrakes)).thenReturn(25573.0);
        Mockito.when(chainAssemblyRepository.getInRange(dateForChainAssemblies)).thenReturn(25573.0);
        Mockito.when(wheelsRepository.getInRange(dateForWheels)).thenReturn(25573.0);
        Mockito.when(seatingRepository.getInRange(dateForSeatings)).thenReturn(25573.0);

        Double response = calculatePricing.calculate("1595672413", "1595672413", "1595672413", "1595672413", "1595672413");

        Mockito.verify(framesRepository).getFrameInRange(dateForFrames);
        Mockito.verify(handleBarAndBrakesRepository).getInRange(dateForHandleAndBrakes);
        Mockito.verify(chainAssemblyRepository).getInRange(dateForChainAssemblies);
        Mockito.verify(wheelsRepository).getInRange(dateForWheels);
        Mockito.verify(seatingRepository).getInRange(dateForSeatings);

        assertEquals(cyclePrice, response);
    }


}
