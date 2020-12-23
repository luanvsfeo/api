package com.luan.api.controller;

import com.luan.api.model.Submission;
import com.luan.api.service.SubmissionService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/submission")
public class SubmissionController {

    private SubmissionService  submissionService;

    public SubmissionController(SubmissionService submissionService) {
        this.submissionService = submissionService;
    }

    @GetMapping
    public ResponseEntity<?> find(@Param("challengeId") Integer challengeId,
                                           @Param("accelerationId") Integer accelerationId){

        List<Submission> submissionList = null;

        if(challengeId != null && accelerationId != null){
            submissionList = submissionService.findByChallengeIdAndAccelerationId(challengeId,accelerationId);
        }else if(challengeId != null ){
            submissionList = Arrays.asList(submissionService.findHigherScoreByChallengeId(challengeId));
        }

        return new ResponseEntity<>(submissionList, HttpStatus.OK);
    }


    @PatchMapping
    public ResponseEntity<Submission> save(@RequestBody  Submission submission){

        Submission resposta = submissionService.save(submission);

        if(resposta != null){
            return new ResponseEntity<>(resposta,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(resposta,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
