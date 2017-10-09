package cad.osb.iaspr_1.console;

import cad.osb.iaspr_1.domain.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String... args) {
        Expert expert1 = new Expert(1, 0);
        Expert expert2 = new Expert(2, 0);
        Expert expert3 = new Expert(3, 0);
        Expert expert4 = new Expert(4, 0);
        Expert expert5 = new Expert(5, 0);

        Question question = new Question(1, "How much?");

        Interval interval1 = new Interval(20, 20, 100, 120, 1);
        Interval interval2 = new Interval(10, 20, 90, 100, 1);
        Interval interval3 = new Interval(40, 50, 140, 180, 1);
        Interval interval4 = new Interval(10, 10, 130, 140, 1);
        Interval interval5 = new Interval(20, 30, 135, 155, 1);

        Answer answer1 = new Answer(question, expert1, interval1);
        Answer answer2 = new Answer(question, expert2, interval2);
        Answer answer3 = new Answer(question, expert3, interval3);
        Answer answer4 = new Answer(question, expert4, interval4);
        Answer answer5 = new Answer(question, expert5, interval5);

        W w1 = new W(answer1);
        W w2 = new W(answer2);
        W w3 = new W(answer3);
        W w4 = new W(answer4);
        W w5 = new W(answer5);

        List<W> wList = new ArrayList<>();
        wList.add(w1);
        wList.add(w2);
        wList.add(w3);
        wList.add(w4);
        wList.add(w5);

        Matrix matrix = Matrix.buildMatrixT(wList);
        System.out.println(matrix);

        Question question2 = new Question(2, "How many?");

        Interval interval21 = new Interval(70, 20, 200, 220, 1);
        Interval interval22 = new Interval(20, 40, 190, 220, 1);
        Interval interval23 = new Interval(40, 30, 230, 260, 1);
        Interval interval24 = new Interval(30, 40, 180, 240, 1);
        Interval interval25 = new Interval(20, 30, 235, 245, 1);

        Answer answer21 = new Answer(question2, expert1, interval21);
        Answer answer22 = new Answer(question2, expert2, interval22);
        Answer answer23 = new Answer(question2, expert3, interval23);
        Answer answer24 = new Answer(question2, expert4, interval24);
        Answer answer25 = new Answer(question2, expert5, interval25);

        W w21 = new W(answer21);
        W w22 = new W(answer22);
        W w23 = new W(answer23);
        W w24 = new W(answer24);
        W w25 = new W(answer25);

        List<W> wList2 = new ArrayList<>();
        wList2.add(w21);
        wList2.add(w22);
        wList2.add(w23);
        wList2.add(w24);
        wList2.add(w25);

        Matrix matrix2 = Matrix.buildMatrixT(wList2);
        System.out.println(matrix2);

        Question question3 = new Question(3, "How why?");

        Interval interval31 = new Interval(10, 15, 70, 75, 1);
        Interval interval32 = new Interval(25, 25, 60, 70, 1);
        Interval interval33 = new Interval(20, 30, 50, 80, 1);
        Interval interval34 = new Interval(10, 15, 55, 65, 1);
        Interval interval35 = new Interval(5, 15, 75, 80, 1);

        Answer answer31 = new Answer(question3, expert1, interval31);
        Answer answer32 = new Answer(question3, expert2, interval32);
        Answer answer33 = new Answer(question3, expert3, interval33);
        Answer answer34 = new Answer(question3, expert4, interval34);
        Answer answer35 = new Answer(question3, expert5, interval35);

        W w31 = new W(answer31);
        W w32 = new W(answer32);
        W w33 = new W(answer33);
        W w34 = new W(answer34);
        W w35 = new W(answer35);

        List<W> wList3 = new ArrayList<>();
        wList3.add(w31);
        wList3.add(w32);
        wList3.add(w33);
        wList3.add(w34);
        wList3.add(w35);

        Matrix matrix3 = Matrix.buildMatrixT(wList3);
        System.out.println(matrix3);

        MatrixCalculator calculator = new MatrixCalculator();
        System.out.println("Reverted:");
        Matrix revertedMatrix = calculator.revertMatixValues(matrix);
        System.out.println(revertedMatrix);
        Matrix revertedMatrix2 = calculator.revertMatixValues(matrix2);
        System.out.println(revertedMatrix2);
        Matrix revertedMatrix3 = calculator.revertMatixValues(matrix3);
        System.out.println(revertedMatrix3);

        Matrix sumMatrix = calculator.sumMatrices(
                Arrays.asList(revertedMatrix, revertedMatrix2, revertedMatrix3)
        );

        System.out.println("Sum");
        System.out.println(sumMatrix);

        CompetencyCalculator ccalc = new CompetencyCalculator();
        List<Double> absoluteCompetency = ccalc.absoluteCompetencyLevels(sumMatrix);
        System.out.println("Abs");
        System.out.println(absoluteCompetency);
        List<Double> relativeCompetency = ccalc.relativeCompetencyLevels(absoluteCompetency);
        System.out.println("Rel");
        System.out.println(relativeCompetency);
    }
}
