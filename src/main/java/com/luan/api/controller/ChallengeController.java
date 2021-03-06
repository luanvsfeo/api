package com.luan.api.controller;

import com.luan.api.model.Challenge;
import com.luan.api.service.ChallengeService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/challenge")
public class ChallengeController {

    private ChallengeService challengeService;

    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @GetMapping
    public ResponseEntity<?> find(@Param("accelerationId")Integer accelerationId,
                               @Param("userId")Integer userId){

        List<Challenge> challengeList = null;

        if(userId != null && accelerationId != null){
            challengeList = challengeService.findByAccelerationIdAndUserId(accelerationId, userId);
        }

        return new ResponseEntity<>(challengeList, HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<Challenge> save(@RequestBody Challenge challenge){
        Challenge resposta = challengeService.save(challenge);

        if(resposta != null){
            return new ResponseEntity<>(resposta,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(resposta,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
