package com.luan.api.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "candidate")
@IdClass(CandidateId.class)
public class Candidate {

    @Id
    private int userId;

    @Id
    private int accelerationId;

    @Id
    private int companyId;

    @Column(name = "STATUS")
    private int status;

    @Column(name = "CREATED_AT")
    private Date createdAt = new Date();

    public Candidate(){
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
