package cad.osb.iaspr_1.service;

import cad.osb.iaspr_1.repository.QuestionRepository;

public class QuestioningServiceImpl implements QuestioningService {

    private QuestionRepository questionRepository;

    public QuestioningServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }
}
