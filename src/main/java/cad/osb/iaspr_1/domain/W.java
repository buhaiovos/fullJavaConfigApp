package cad.osb.iaspr_1.domain;

public class W {
    private Answer answer;
    private double value = -1.0;

    public W() {
    }

    public W(Answer answer) {
        this.answer = answer;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public double getValue() {
        if (value > 0) {
            return value;
        }
        value = calculateValue(answer);
        return value;
    }

    public int getExpertId() {
        return answer.getExpert().getId();
    }

    public int getQuestionId() {
        return answer.getQuestion().getId();
    }

    private double calculateValue(Answer answer) {
        Interval interval = answer.getInterval();
        return applyFormula(
                interval.getAlpha(), interval.getBeta(),
                interval.getMLow(), interval.getMHigh(),
                interval.getH()
        );
    }

    private double applyFormula(
            double alpha, double beta, double mLow, double mHigh, double h) {
        return (h/2) * (mLow + mHigh) + (h/4) * (beta - alpha);
    }

}
