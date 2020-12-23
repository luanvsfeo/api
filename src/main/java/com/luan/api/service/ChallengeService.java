package com.luan.api.service;

import com.luan.api.model.Challenge;
import com.luan.api.repository.ChallengeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChallengeService {

    private final ChallengeRepository challengeRepository;

    public ChallengeService(ChallengeRepository challengeRepository) {
        this.challengeRepository = challengeRepository;
    }

    public List<Challenge> findByAccelerationIdAndUserId(int accelerationId, int userId){
        return challengeRepository.findByAccelerationIdAndUserId(accelerationId,userId);
    }

    public Challenge save(Challenge challenge){
        return challengeRepository.save(challenge);
    }

}
