package cad.osb.iaspr_1.domain;

import java.util.ArrayList;
import java.util.List;

public class SixQuestionTypeAlgorithmExecutor implements AlgorithmExecutor {
    @Override
    public List<Double> calculateCompetencies(
            List<List<Answer>> orderedByExpertsAnswers) {
        int expertsNum = orderedByExpertsAnswers.size();
        int questionsNum = orderedByExpertsAnswers.get(0).size();
        // 0. get answers for each question separately
        List<List<Answer>> answersOrderedByQuestionId = reorganizeAnswersByQuestionId(orderedByExpertsAnswers, questionsNum);
        // 1. build list of W for each question
        List<List<W>> listsOfOmegasForEachQuestion = packOmegasForEachQuestion(answersOrderedByQuestionId);
        // 2. build matrix for each list from (1)
        List<Matrix> matrices = buildMatricesForEachQuesiton(listsOfOmegasForEachQuestion);
        // 3. revert each matrix
        List<Matrix> invertedMatrices = invertMatrices(matrices);
        // 4. sum all matrices
        Matrix invertedSummedMatrix = new MatrixCalculator().sumMatrices(invertedMatrices);

        return calculateCompetencies(invertedSummedMatrix);
    }

    private List<Double> calculateCompetencies(Matrix invertedSummedMatrices) {
        CompetencyCalculator cc = new CompetencyCalculator();
        List<Double> absoluteCompetencies = cc.absoluteCompetencyLevels(invertedSummedMatrices);

        return cc.relativeCompetencyLevels(absoluteCompetencies);
    }

    private List<Matrix> invertMatrices(List<Matrix> matrices) {
        MatrixCalculator mc = new MatrixCalculator();
        List<Matrix> revertedMatrices = new ArrayList<>();
        for (Matrix notRevertedMatrix : matrices) {
            revertedMatrices.add(mc.revertMatixValues(notRevertedMatrix));
        }

        return revertedMatrices;
    }

    private List<Matrix> buildMatricesForEachQuesiton(List<List<W>> listsOfOmegasForEachQuestion) {
        List<Matrix> matrices = new ArrayList<>();
        for (List<W> listOfOmegasForQuestion : listsOfOmegasForEachQuestion) {
            matrices.add(Matrix.buildMatrixT(listOfOmegasForQuestion));
        }
        return matrices;
    }

    private List<List<W>> packOmegasForEachQuestion(List<List<Answer>> answersOrderedByQuestionId) {
        int questionNum = answersOrderedByQuestionId.size();
        List<List<W>> listsOfOmegasForEachQuestion = new ArrayList<>();
        for (int questionId = 0; questionId < questionNum; questionId++) {
            List<Answer> answersOfAllExpertsToSingleQuestion  = answersOrderedByQuestionId.get(questionId);
            listsOfOmegasForEachQuestion.add(new ArrayList<>());
            for (Answer answerOfExpert : answersOfAllExpertsToSingleQuestion) {
                listsOfOmegasForEachQuestion.get(questionId).add(new W(answerOfExpert));
            }
        }
        return listsOfOmegasForEachQuestion;
    }

    private List<List<Answer>> reorganizeAnswersByQuestionId(List<List<Answer>> orderedByExpertsAnswers, int questionsNum) {
        List<List<Answer>> answersOrderedByQuestionId = new ArrayList<>();
        for (int questionId = 0; questionId < questionsNum; questionId++) {
            answersOrderedByQuestionId.add(new ArrayList<>());
            for (List<Answer> singleExpertAnswers : orderedByExpertsAnswers) {
                answersOrderedByQuestionId.get(questionId).add(singleExpertAnswers.get(questionId));
            }
        }
        return answersOrderedByQuestionId;
    }
}
