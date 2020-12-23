package com.luan.api.model;

import java.io.Serializable;

public class SubmissionId implements Serializable {

    private int userId;

    private int challengeId;

    public SubmissionId(int userId, int challengeId) {
        this.userId = userId;
        this.challengeId = challengeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getChallengeId() {
        return challengeId;
    }

    public void setChallengeId(int challengeId) {
        this.challengeId = challengeId;
    }
}
