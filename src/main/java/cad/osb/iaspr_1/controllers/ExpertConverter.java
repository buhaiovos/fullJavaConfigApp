package cad.osb.iaspr_1.controllers;

import cad.osb.iaspr_1.domain.Expert;
import org.springframework.core.convert.converter.Converter;

public class ExpertConverter implements Converter<String, Expert> {
    @Override
    public Expert convert(String s) {
        System.out.println("INSIDE EXPERT CONVERTER : " + s);
        String[] expertParams = s.split("\\s");
        return new Expert(
            Integer.parseInt(expertParams[0]),
            Double.parseDouble(expertParams[1])
        );
    }
}
