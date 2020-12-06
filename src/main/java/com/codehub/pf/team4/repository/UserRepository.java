package com.codehub.pf.team4.repository;

import com.codehub.pf.team4.domains.Repair;
import com.codehub.pf.team4.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(Long id);
    Optional<User> findByAfm(Integer afm);
    Optional<User> findByEmail(String email);

//    @Query(value ="SELECT u FROM User u JOIN FETCH u.repairs WHERE u.afm = (:afm)", nativeQuery = true)
//    List<User> findRepairsByAfm(@Param("afm") Integer afm);

//    @Query(value ="SELECT r.* FROM users u JOIN FETCH repair r ON r.user_id = u.user_id WHERE u.user_id = (:id)", nativeQuery = true)
//    List<Repair> findRepairsByUserId(@Param("id") Long id);

}
