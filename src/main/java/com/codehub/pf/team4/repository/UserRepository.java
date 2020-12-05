package com.codehub.pf.team4.repository;

import com.codehub.pf.team4.Tables.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(Long id);
    Optional<User> findByAfm(Integer afm);
    Optional<User> findByEmail(String email);

    /*@Query(value ="SELECT u FROM User u JOIN FETCH u.repairs WHERE u.afm = (:afm)")
    List<User> findRepairsByAfm(@Param("afm") Integer afm);
    AYTO PREPEI NA DOULEPSEI
     */
}
