package com.luan.api.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "submission")
@IdClass(SubmissionId.class)
public class Submission {


    @Id
    private int userId;

    @Id
    private int challengeId;


    @Column(name = "SCORE")
    private float score;

    @Column(name = "CREATED_AT")
    private Date createdAt = new Date();

    public Submission() {
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

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
