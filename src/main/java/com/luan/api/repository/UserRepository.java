package com.luan.api.repository;

import com.luan.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query(nativeQuery = true,
            value = "select u.* from user u inner join candidate c on c.user_id = u.id inner join on acceleration a on a.id = c.acceleration_id where a.name = :accelerationName")
    List<User> findByAccelerationName(@Param("accelerationName") String accelerationName);

    @Query(nativeQuery = true,
            value = "select u.* from user u inner join candidate c on c.user_id = u.id where c.company_id = :companyId")
    List<User> findByCompanyId(@Param("companyId") int companyId);
}
