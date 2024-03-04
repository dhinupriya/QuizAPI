package com.RegisterQuizApplication.Registration;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz,Integer> {
    @Query(
            value = "select   question_id,question_text,option_a,option_b,option_c,option_d from myschema.questions limit 10;",
            nativeQuery = true)
    List<Quiz> getQuizQuestions();

    @Query(
            value = "select   question_id,question_text,option_a,option_b,option_c,option_d from myschema.questions where field=:field limit 10",
            nativeQuery = true)
    List<Quiz> getQuizQuestionsField(String field);
}
