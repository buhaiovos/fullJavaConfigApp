package cad.osb.iaspr_1.domain;

public class Answer {

    private Question question;
    private Expert expert;
    private Interval asnwerInterwal;

    public Answer() {
    }

    public Answer(Question question, Expert expert, Interval asnwerInterwal) {
        this.question = question;
        this.expert = expert;
        this.asnwerInterwal = asnwerInterwal;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Interval getAsnwerInterwal() {
        return asnwerInterwal;
    }

    public void setAsnwerInterwal(Interval asnwerInterwal) {
        this.asnwerInterwal = asnwerInterwal;
    }

    public Expert getExpert() {
        return expert;
    }

    public void setExpert(Expert expert) {
        this.expert = expert;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Answer)) return false;

        Answer answer = (Answer) o;

        if (!question.equals(answer.question)) return false;
        return expert.equals(answer.expert);
    }

    @Override
    public int hashCode() {
        int result = question.hashCode();
        result = 31 * result + expert.hashCode();
        return result;
    }
}
