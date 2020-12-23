package com.luan.api.repository;

import com.luan.api.model.Acceleration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccelerationRepository extends JpaRepository<Acceleration,Integer> {


    Optional<Acceleration> findByName(String name);

    @Query(nativeQuery = true,
            value = "select * from acceleration a inner join candidate c on c.acceleration_id = a.id " +
            "where  " +
            " c.company_id  = :companyId")
    List<Acceleration> findByCompanyId(int companyId);
}
