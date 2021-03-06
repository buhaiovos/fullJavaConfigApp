package cad.osb.iaspr_1.domain;

import lombok.ToString;

@ToString
public class Question {
    private int id;
    private String text;

    public Question() {
    }

    public Question(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question)) return false;

        Question question = (Question) o;

        return id == question.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
