package com.codehub.pf.team4.Property_Repairs.repository;

import com.codehub.pf.team4.Property_Repairs.Tables.Repair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairRepository extends JpaRepository<Repair, Long> {
}
