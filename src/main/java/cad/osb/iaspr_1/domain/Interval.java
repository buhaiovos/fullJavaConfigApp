package cad.osb.iaspr_1.domain;

import lombok.Data;

@Data
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

}
