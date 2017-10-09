package cad.osb.iaspr_1.domain;

import java.util.ArrayList;
import java.util.List;

public class MatrixCalculator {

    private List<MatrixElementPosition> zeroElementsWhichNeedRecalculation =
            new ArrayList<>();

    public MatrixCalculator() {
    }

    public Matrix sumMatrices(List<Matrix> matrices) {
        if (matrices.size() != 0) {
            int size = matrices.get(0).size();
            double[][] sumMatrix = new double[size][size];

            for (Matrix currentMatrix : matrices) {
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < i; j++) {
                        sumMatrix[i][j] += currentMatrix.get(i,j);
                    }
                }
            }

            return Matrix.buildMatrix(sumMatrix);
        }
        throw new RuntimeException("Empty list of matrices. Nothing to sum");
    }

    public Matrix revertMatixValues(Matrix matrix) {
        int size = matrix.size();
        double[][] matrixWithInvertedValues = new double[size][size];

        for (int i = 1; i < size; i++) {
            for (int j = 0; j < i; j++) {
                if (matrix.get(i, j) == 0) {
                    zeroElementsWhichNeedRecalculation
                            .add(new MatrixElementPosition(i, j));
                    continue;
                }
                matrixWithInvertedValues[i][j] = 1.0 / matrix.get(i,j);
            }
        }

        if (zeroElementsWhichNeedRecalculation.size() > 0) {
            matrixWithInvertedValues =
                    recalculateZeroElements(
                            matrixWithInvertedValues,
                            zeroElementsWhichNeedRecalculation
                    );
        }

        return Matrix.buildMatrix(matrixWithInvertedValues);
    }

    private double[][] recalculateZeroElements(double[][] matrix,
                                               List<MatrixElementPosition> elementsToRecalculate) {
        double maxValue = findMaxValue(matrix);
        for (MatrixElementPosition pos : elementsToRecalculate) {
            matrix[pos.row][pos.column] = maxValue * 2;
        }

        return matrix;
    }

    private double findMaxValue(double[][] matrix) {
        double max = matrix[1][0];
        for (int i = 2; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }
        return max;
    }

    private static class MatrixElementPosition {
        private int row, column;

        public MatrixElementPosition(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

}
