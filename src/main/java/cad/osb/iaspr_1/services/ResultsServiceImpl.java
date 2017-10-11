package cad.osb.iaspr_1.services;

import cad.osb.iaspr_1.domain.AlgorithmExecutor;
import cad.osb.iaspr_1.dto.ResultDTO;

import java.util.ArrayList;
import java.util.List;

public class ResultsServiceImpl implements ResultsService {

    private AnswerService answerService;
    private AlgorithmExecutor executor;

    public ResultsServiceImpl(AnswerService answerService, AlgorithmExecutor executor) {
        this.answerService = answerService;
        this.executor = executor;
    }

    @Override
    public List<ResultDTO> getResults() {
        List<Double> competencies =
                executor.calculateCompetencies(
                        answerService.getAnswersListsOrderedByExpertId()
                );
        List<ResultDTO> results = packResults(competencies);
        return results;
    }

    private List<ResultDTO> packResults(List<Double> competencies) {
        if (competencies.size() == 0) {
            throw new RuntimeException("ResulutServcieImpl: no competencies returned!");
        }
        List<ResultDTO> resultDTOS = new ArrayList<>();
        for (int i = 0; i < competencies.size(); i++) {
            resultDTOS.add(new ResultDTO(i, competencies.get(i)));
        }
        return resultDTOS;
    }
}
