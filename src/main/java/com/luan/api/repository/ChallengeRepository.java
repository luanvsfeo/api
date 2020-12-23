package com.luan.api.repository;

import com.luan.api.model.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChallengeRepository extends JpaRepository<Challenge,Integer> {

    @Query(nativeQuery = true,
            value = "select c.* from challenge c  " +
                    "inner join acceleration a on a.challenge_id = c.id  " +
                    "inner join candidate c2 on c2.acceleration_id  = a.challenge_id  " +
                    "where c2.user_id = :userId " +
                    "and a.id = :accelerationId")
    Optional<Challenge> findByAccelerationIdAndUserId(@Param("accelerationId") int accelerationId,
                                                      @Param("userId") int userId);
}
