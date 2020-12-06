package com.codehub.pf.team4.repository;

import com.codehub.pf.team4.domains.Repair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepairRepository extends JpaRepository<Repair, java.lang.Long> {}
