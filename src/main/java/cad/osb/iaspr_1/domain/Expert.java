package cad.osb.iaspr_1.domain;

public class Expert {
    private int id;
    private double expectedCompetency;

    public Expert() {
    }

    public Expert(int id, double expectedCompetency) {
        this.id = id;
        this.expectedCompetency = expectedCompetency;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getExpectedCompetency() {
        return expectedCompetency;
    }

    public void setExpectedCompetency(double expectedCompetency) {
        this.expectedCompetency = expectedCompetency;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (! (o instanceof Expert)) {
            return false;
        }
        Expert otherExpert = (Expert) o;
        if (this.id != otherExpert.id) {
            return false;
        }
        return true;
    }
}
