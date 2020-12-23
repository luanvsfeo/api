package com.luan.api.repository;

import com.luan.api.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Integer> {

    @Query(nativeQuery = true,
            value = "select c.* from company c inner join candidate c2 on  c2.company_id  = c.id " +
                    "where c2.acceleration_id  = :accelerationId ")
    List<Company> findByAccelerationId(@Param("accelerationId") int accelerationId);

    @Query(nativeQuery = true,
            value = " select c.* from company c inner join candidate c2 on  c2.company_id  = c.id " +
            "where c2.user_id  = :userId")
    List<Company> findByUserId(@Param("userId") int userId);
}
