package cad.osb.iaspr_1.services;

import cad.osb.iaspr_1.domain.Expert;
import cad.osb.iaspr_1.domain.Question;

import java.util.List;

public interface QuestioningService {
    List<Question> getAllQuestions();
    int getQuestionsNum();
}
