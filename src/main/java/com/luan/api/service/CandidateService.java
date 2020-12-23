package com.luan.api.service;

import com.luan.api.model.Candidate;
import com.luan.api.repository.CandidateRepository;
import org.springframework.stereotype.Service;

@Service
public class CandidateService {

    private final CandidateRepository candidateRepository;

    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public Candidate findByCompanyId(int companyId){
        return candidateRepository.findByCompanyId(companyId).orElse(null);
    }

    public Candidate findByAccelerationId(int accelerationId){
        return candidateRepository.findByAccelerationId(accelerationId).orElse(null);
    }

    public Candidate save(Candidate candidate){
        return candidateRepository.save(candidate);
    }

}
