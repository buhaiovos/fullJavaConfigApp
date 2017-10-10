package cad.osb.iaspr_1.controllers;

import cad.osb.iaspr_1.domain.Question;
import org.springframework.core.convert.converter.Converter;

public class QuestionConverter implements Converter<String, Question> {
    @Override
    public Question convert(String s) {
        System.out.println("INSIDE QUESTION CONVERTER : " + s);
        String[] questionParams = s.split(":");
        return new Question(
            Integer.parseInt(questionParams[0]),
            questionParams[1]
        );
    }
}
