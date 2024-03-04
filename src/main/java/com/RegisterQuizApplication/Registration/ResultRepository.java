package com.RegisterQuizApplication.Registration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ResultRepository extends JpaRepository<Result,Integer> {
    @Query(
            value = "select  question_id,correct_option from myschema.questions order by question_id;",
            nativeQuery = true)
    List<Result> getAnswers();
}
