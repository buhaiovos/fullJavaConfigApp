package cad.osb.iaspr_1.services;

import cad.osb.iaspr_1.domain.Answer;
import cad.osb.iaspr_1.domain.Interval;
import cad.osb.iaspr_1.domain.Question;

import java.util.ArrayList;
import java.util.List;

public class AnswerServiceImpl implements AnswerService {

    private QuestioningService questioningService;
    private List<List<Answer>> answersListsOrderedByExpertId = new ArrayList<>();

    public AnswerServiceImpl(QuestioningService questioningService) {
        this.questioningService = questioningService;
    }

    @Override
    public List<Answer> getEmptyAnswers() {

        List<Question> questions = questioningService.getAllQuestions();
        List<Answer> emptyAnswers = new ArrayList<>();

        for (Question q : questions) {
            emptyAnswers.add(new Answer(q, null, new Interval()));
        }

        return emptyAnswers;
    }

    @Override
    public List<List<Answer>> getAnswersListsOrderedByExpertId() {
        return answersListsOrderedByExpertId;
    }

    @Override
    public synchronized void saveAnswers(List<Answer> answers) {
        System.out.println("Saving : " + answers.toString());
        answersListsOrderedByExpertId.add(answers);
    }
}
