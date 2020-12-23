package com.luan.api.model;

import java.io.Serializable;


public class CandidateId implements Serializable {

    private int userId;

    private int accelerationId;

    private int companyId;

    public CandidateId() {
    }

    public CandidateId(int userId, int accelerationId, int companyId) {
        this.userId = userId;
        this.accelerationId = accelerationId;
        this.companyId = companyId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAccelerationId() {
        return accelerationId;
    }

    public void setAccelerationId(int accelerationId) {
        this.accelerationId = accelerationId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }


}
