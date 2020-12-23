package com.luan.api.service;

import com.luan.api.model.Company;
import com.luan.api.repository.CompanyRepository;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company findById(int id){
        return companyRepository.findById(id).orElse(null);
    }

    public Company findByAccelerationId(int accelerationId){
        return companyRepository.findByAccelerationId(accelerationId).orElse(null);
    }

    public Company findByUserId(int userId){
        return  companyRepository.findByUserId(userId).orElse(null);
    }

    public Company save(Company company){
        return companyRepository.save(company);
    }
}
