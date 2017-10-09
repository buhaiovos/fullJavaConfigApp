package cad.osb.iaspr_1.domain;

import java.util.ArrayList;
import java.util.List;

public class CompetencyCalculator {

    public List<Double> absoluteCompetencyLevels(Matrix invertedSummedMatrix) {
        int size = invertedSummedMatrix.size();
        List<Double> absoluteCompetencies = getListFor(size);
        for (int i = 1; i < size; i++) {
            for (int j = 0; j < i; j++) {
                increaseAbsCompetency(i, absoluteCompetencies,
                        invertedSummedMatrix.get(i,j));
                increaseAbsCompetency(j, absoluteCompetencies,
                        invertedSummedMatrix.get(i,j));
            }
        }
        return absoluteCompetencies;
    }

    public List<Double> relativeCompetencyLevels(List<Double> absoluteCompetencies) {
        Double sum = getSumForList(absoluteCompetencies);
        List<Double> relativeCompetencies = new ArrayList<>(absoluteCompetencies);
        for (int i = 0; i < relativeCompetencies.size(); i++) {
            relativeCompetencies.set(i, relativeCompetencies.get(i)/sum);
        }
        return relativeCompetencies;
    }

    private Double getSumForList(List<Double> absoluteCompetencies) {
        Double sum = 0.0;
        for (Double absCompetency : absoluteCompetencies) {
            sum += absCompetency;
        }
        return sum;
    }

    private Double increaseAbsCompetency(int index, List<Double> absoluteCompetencies, double addition) {
        Double newValue = absoluteCompetencies.get(index) + addition;
        absoluteCompetencies.set(index, newValue);
        return newValue;
    }

    private List<Double> getListFor(int size) {
        List<Double> list = new ArrayList<>(size + (int)(size*0.3));
        for (int i = 0; i < size; i++) {
            list.add(0.0);
        }
        return list;
    }
}
