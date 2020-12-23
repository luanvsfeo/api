package com.luan.api.controller;

import com.luan.api.model.Candidate;
import com.luan.api.service.CandidateService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    private CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping
    public ResponseEntity<Candidate> find(@Param("companyId") Integer companyId,
                     @Param("accelerationId") Integer accelerationId){

        Candidate candidate = null;

        if(companyId != null){
            candidate = candidateService.findByCompanyId(companyId);
        }else if(accelerationId != null){
            candidate = candidateService.findByAccelerationId(accelerationId);
        }


        return new ResponseEntity<>(candidate, HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<Candidate> save(@RequestBody Candidate candidate){
        Candidate resposta = candidateService.save(candidate);

        if(resposta != null){
            return new ResponseEntity<>(resposta,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(resposta,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}