package cad.osb.iaspr_1.controller;

import cad.osb.iaspr_1.service.QuestioningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QuestioningController {

    private QuestioningService questioningService;

    @Autowired
    public QuestioningController(QuestioningService questioningService) {
        this.questioningService = questioningService;
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
