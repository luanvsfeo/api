package com.luan.api.service;

import com.luan.api.model.Submission;
import com.luan.api.repository.SubmissionRepository;
import org.springframework.stereotype.Service;

@Service
public class SubmissionService {

    private final SubmissionRepository submissionRepository;

    public SubmissionService(SubmissionRepository submissionRepository) {
        this.submissionRepository = submissionRepository;
    }

    public Submission findHigherScoreByChallengeId(int challengeId){
        return submissionRepository.findHigherScoreByChallengeId(challengeId).orElse(null);
    }

    public Submission findByChallengeIdAndAccelerationId(int challengeId, int accelerationId){
        return submissionRepository.findByChallengeIdAndAccelerationId(challengeId,accelerationId).orElse(null);
    }

    public Submission save(Submission submission){
        return submissionRepository.save(submission);
    }
}
