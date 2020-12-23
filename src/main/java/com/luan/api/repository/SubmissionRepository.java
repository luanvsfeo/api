package com.luan.api.repository;

import com.luan.api.model.Submission;
import com.luan.api.model.SubmissionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission, SubmissionId> {

    @Query(nativeQuery = true, value = "select s.* from submission s where s.challenge_id = :challengeId order by s.score desc")
    Optional<Submission> findHigherScoreByChallengeId(@Param("challengeId") int challengeId);

    @Query(nativeQuery = true, value = "select s.* from submission s  " +
            "where " +
            "s.user_id in (select user_id from candidate c where c.acceleration_id = :accelerationId) " +
            "and s.challenge_id  =  :challengeId ")
    List<Submission> findByChallengeIdAndAccelerationId(@Param("challengeId") int challengeId,
                                                        @Param("accelerationId") int accelerationId);
}
