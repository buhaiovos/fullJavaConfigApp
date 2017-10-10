package cad.osb.iaspr_1.repositories;

import cad.osb.iaspr_1.domain.Question;

import java.util.List;

public interface QuestionRepository {
    List<Question> allQuestions();
}
