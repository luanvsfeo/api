package com.luan.api.controller;

import com.luan.api.model.Candidate;
import com.luan.api.service.CandidateService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    private CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping
    public ResponseEntity<?> find(@Param("companyId") Integer companyId,
                     @Param("accelerationId") Integer accelerationId){

        List<Candidate> candidateList = null;

        if(companyId != null){
            candidateList = Arrays.asList(candidateService.findByCompanyId(companyId));
        }else if(accelerationId != null){
            candidateList = candidateService.findByAccelerationId(accelerationId);
        }


        return new ResponseEntity<>(candidateList, HttpStatus.OK);
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