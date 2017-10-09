package cad.osb.iaspr_1.domain;

import java.util.Comparator;
import java.util.List;
import static java.lang.Math.*;

public class Matrix {

    private double[][] matrix;

    private Matrix(double[][] matrix) {
        this.matrix = matrix;
    }

    public double get(int row, int column) {
        return matrix[row][column];
    }

    public int size() {
        return matrix.length;
    }

    public static Matrix buildMatrix(double[][] matrix) {
        return new Matrix(matrix);
    }

    public static Matrix buildMatrixT(List<W> wList) {
        double[][] matrix = new double[wList.size()][wList.size()];
        matrix = fillMatrixWithValues(matrix, wList);
        return new Matrix(matrix);
    }

    private static double[][] fillMatrixWithValues(double[][] matrix,
                                                   List<W> wList) {
        Comparator<W> comparator = (o1, o2) -> {
            double o1Val = o1.getValue();
            double o2Val = o2.getValue();

            if (o1Val > o2Val) {
                return 1;
            }
            if (o1Val < o2Val) {
                return -1;
            }
            return 0;
        };

        W max = wList.stream().max(comparator).get();
        W min = wList.stream().min(comparator).get();

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                matrix[i][j] =
                        abs(wList.get(i).getValue() - wList.get(j).getValue())
                         / (max.getValue() - min.getValue());
            }
        }

        return matrix;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Matrix:\n");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sb.append(String.format("%.5f", matrix[i][j])).append("  ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
