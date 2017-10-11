package cad.osb.iaspr_1.controllers;

import cad.osb.iaspr_1.dto.ResultDTO;
import cad.osb.iaspr_1.services.ExpertService;
import cad.osb.iaspr_1.services.QuestioningService;
import cad.osb.iaspr_1.services.ResultsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/results")
public class ResultsController {

    private ExpertService expertService;
    private QuestioningService questioningService;
    private ResultsService resultsService;

    @Autowired
    public ResultsController(ExpertService expertService,
                             QuestioningService questioningService,
                             ResultsService resultsService) {
        this.expertService = expertService;
        this.questioningService = questioningService;
        this.resultsService = resultsService;
    }

    @RequestMapping("/start")
    public String getStartPage(Model model) {
        model.addAttribute("expertsNum", expertService.getExpertsNum());
        model.addAttribute("questionsNum", questioningService.getQuestionsNum());

        return "resultsStartPage";
    }

    @RequestMapping("finish")
    public String getResults(Model model) {
        List<ResultDTO> results = resultsService.getResults();
        model.addAttribute("results", results);

        return "resultPage";
    }
}
