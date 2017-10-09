package cad.osb.iaspr_1.domain;

public class Interval {

    private double alpha;
    private double beta;
    private double mLow;
    private double mHigh;
    private double h;

    public Interval() {
    }

    public Interval(double alpha, double beta, double mLow, double mHigh, double h) {
        this.alpha = alpha;
        this.beta = beta;
        this.mLow = mLow;
        this.mHigh = mHigh;
        this.h = h;
    }

    public double getAlpha() {
        return alpha;
    }

    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }

    public double getBeta() {
        return beta;
    }

    public void setBeta(double beta) {
        this.beta = beta;
    }

    public double getmLow() {
        return mLow;
    }

    public void setmLow(double mLow) {
        this.mLow = mLow;
    }

    public double getmHigh() {
        return mHigh;
    }

    public void setmHigh(double mHigh) {
        this.mHigh = mHigh;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }
}
