package cad.osb.iaspr_1.domain;

import java.util.List;

public interface AlgorithmExecutor {
    List<Double> calculateCompetencies(List<List<Answer>> orderedExpertsAnswers);
}
