package com.luan.api.service;

import com.luan.api.model.Acceleration;
import com.luan.api.repository.AccelerationRepository;
import org.springframework.stereotype.Service;

@Service
public class AccelerationService {

    private final AccelerationRepository accelerationRepository;

    public AccelerationService(AccelerationRepository accelerationRepository) {
        this.accelerationRepository = accelerationRepository;
    }

    public Acceleration findAccelerationById(int accelerationId){
        return accelerationRepository.findById(accelerationId).orElse(null);
    }

    public Acceleration findAccelerationByName(String accelerationName){
        return accelerationRepository.findByName(accelerationName).orElse(null);
    }

    public Acceleration findByCompanyId(int companyId){
        return accelerationRepository.findByCompanyId(companyId).orElse(null);
    }

    public Acceleration save(Acceleration acceleration){
        return accelerationRepository.save(acceleration);
    }

}
