package cad.osb.iaspr_1.repository;

import cad.osb.iaspr_1.domain.Question;

import java.util.List;

public interface QuestionRepository {
    List<Question> allQuestions();
}
