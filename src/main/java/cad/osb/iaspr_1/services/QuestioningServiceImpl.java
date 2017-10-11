package cad.osb.iaspr_1.services;

import cad.osb.iaspr_1.domain.Question;
import cad.osb.iaspr_1.repositories.QuestionRepository;

import java.util.List;

public class QuestioningServiceImpl implements QuestioningService {

    private QuestionRepository questionRepository;

    public QuestioningServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.allQuestions();
    }

    @Override
    public int getQuestionsNum() {
        return questionRepository.allQuestions().size();
    }
}
