package cad.osb.iaspr_1.services;

import cad.osb.iaspr_1.domain.Answer;
import cad.osb.iaspr_1.domain.Expert;

import java.util.List;

public interface AnswerService {
    List<Answer> getEmptyAnswers();
    List<List<Answer>> getAnswersListsOrderedByExpertId();
    void saveAnswers(List<Answer> answers);
}
