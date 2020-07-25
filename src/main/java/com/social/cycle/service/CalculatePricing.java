package com.social.cycle.service;

import com.social.cycle.model.ChainAssembly;
import com.social.cycle.model.Frames;
import com.social.cycle.model.HandleBarAndBrakes;
import com.social.cycle.model.Seating;
import com.social.cycle.model.Wheels;
import com.social.cycle.repository.ChainAssemblyRepository;
import com.social.cycle.repository.FramesRepository;
import com.social.cycle.repository.HandleBarAndBrakesRepository;
import com.social.cycle.repository.SeatingRepository;
import com.social.cycle.repository.WheelsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CalculatePricing {
    @Autowired
    FramesRepository framesRepository;
    @Autowired
    ChainAssemblyRepository chainAssemblyRepository;
    @Autowired
    HandleBarAndBrakesRepository handleBarAndBrakesRepository;
    @Autowired
    SeatingRepository seatingRepository;
    @Autowired
    WheelsRepository wheelsRepository;

    public Double calculate(String dateForFrame, String dateForChainAssembly, String dateForHandleAndBrake, String dateForWheel, String dateForSeating) throws ParseException {

        long dateForFrames = new SimpleDateFormat("dd/MM/yyyy").parse(dateForFrame).getTime();
        long dateForChainAssemblies = new SimpleDateFormat("dd/MM/yyyy").parse(dateForChainAssembly).getTime();
        long dateForHandleAndBrakes = new SimpleDateFormat("dd/MM/yyyy").parse(dateForHandleAndBrake).getTime();
        long dateForWheels = new SimpleDateFormat("dd/MM/yyyy").parse(dateForWheel).getTime();
        long dateForSeatings = new SimpleDateFormat("dd/MM/yyyy").parse(dateForSeating).getTime();

        Double frames = framesRepository.getFrameInRange(dateForFrames);
        Double chainAssembly = chainAssemblyRepository.getInRange(dateForChainAssemblies);
        Double handleBarAndBrakes = handleBarAndBrakesRepository.getInRange(dateForHandleAndBrakes);
        Double wheels = wheelsRepository.getInRange(dateForWheels);
        Double seating = seatingRepository.getInRange(dateForSeatings);

        return (frames + chainAssembly + handleBarAndBrakes + wheels + seating);
    }
}
