package cad.osb.iaspr_1.repository;

import cad.osb.iaspr_1.domain.Question;

import java.util.ArrayList;
import java.util.List;

public class InMemQuestionRepository implements QuestionRepository {

    @Override
    public List<Question> allQuestions() {
        return new ArrayList<Question>() {
            {
                add(new Question(0, "В каких пределах финансирование " +
                        "научных исследований на промышленном предприятии (ПП) " +
                        "является оптимальным?"));
                add(new Question(1, "Какие сроки будут оптимальными, " +
                        "по мнению эксперта, для ввода ПП в эксплуатацию?"));
                add(new Question(2, "Какая прибыль ожидается в " +
                        "первый год функционирования ПП?"));
            }
        };
    }
}
