package com.luan.api.repository;

import com.luan.api.model.Candidate;
import com.luan.api.model.CandidateId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, CandidateId> {

    @Query(nativeQuery = true, value = "select * from candidate c where c.company_id  = :companyId")
    Optional<Candidate> findByCompanyId(@Param("companyId") int companyId);


    @Query(nativeQuery = true, value = "select * from candidate c where c.acceleration_id  = :acceleration_id ")
    List<Candidate> findByAccelerationId(@Param("acceleration_id") int accelerationId);
}
