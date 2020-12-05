package com.codehub.pf.team4.repository;

import com.codehub.pf.team4.Tables.Repair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepairRepository extends JpaRepository<Repair, java.lang.Long> {

    @Query(value = "SELECT r.* FROM repair r JOIN users u ON r.user_id = u.user_id WHERE u.afm = (:afm)", nativeQuery = true)
    List<Repair> findAllByAfm(@Param("afm") Integer afm);
}
