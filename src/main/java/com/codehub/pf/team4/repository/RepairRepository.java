package com.codehub.pf.team4.repository;

import com.codehub.pf.team4.domains.Repair;
import com.codehub.pf.team4.enums.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface RepairRepository extends JpaRepository<Repair, java.lang.Long> {
    //@Query("SELECT r FROM Repair r WHERE (r.date BETWEEN :start AND :end) AND state = :state")/// Tha mas ferei ta repairs ths hmeras
    List<Repair> findByDateIsBetweenAndStateEquals(Timestamp start, Timestamp end, State state);
    List<Repair> findByDateIsBetween(Timestamp start, Timestamp end);
    @Query(value = "SELECT r.* FROM Repair r WHERE CAST(r.date AS DATE) = CAST(:searchDate AS DATE)", nativeQuery = true)
    List<Repair> findByDateLike(Timestamp searchDate);
}
