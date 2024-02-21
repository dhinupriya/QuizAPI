package com.RegisterQuizApplication.Registration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Registration,Integer> {

    @Query(
            value = "SELECT password FROM myschema.user  WHERE user_name  = :username",
            nativeQuery = true)
    String getpasswordbyusername(String username);
}
