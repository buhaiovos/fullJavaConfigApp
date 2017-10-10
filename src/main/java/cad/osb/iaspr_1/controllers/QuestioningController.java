package cad.osb.iaspr_1.controllers;

import cad.osb.iaspr_1.domain.Answer;
import cad.osb.iaspr_1.domain.Expert;
import cad.osb.iaspr_1.domain.Interval;
import cad.osb.iaspr_1.domain.Question;
import cad.osb.iaspr_1.dto.AnswerDTO;
import cad.osb.iaspr_1.services.AnswerService;
import cad.osb.iaspr_1.services.ExpertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class QuestioningController {

    private AnswerService answerService;
    private ExpertService expertService;

    @Autowired
    public QuestioningController(AnswerService answerService,
                                 ExpertService expertService) {
        this.answerService = answerService;
        this.expertService = expertService;
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping(value = "/questioning", method = RequestMethod.GET)
    public ModelAndView getQuestions(Model model) {
        List<Answer> emptyAnswers = answerService.getEmptyAnswers();
        AnswerDTO answerDTO = new AnswerDTO();
        answerDTO.setAnswers(emptyAnswers);

        return new ModelAndView("questionList", "answerDTO", answerDTO);
    }

    @RequestMapping(value = "/questioning", method = RequestMethod.POST)
    public ModelAndView getQuestions(AnswerDTO answerDTO, Model model) {
        List<Answer> answers = answerDTO.getAnswers();
        Expert currentExpert = expertService.getNextExpert();

        for (Answer a : answers) {
            a.setExpert(currentExpert);
            System.out.println();
            System.out.println(a.getExpert());
            System.out.println(a.getInterval());
            System.out.println(a.getQuestion());
        }
        answerService.saveAnswers(answers);
        return new ModelAndView("hello", "expertId", new Integer(currentExpert.getId()));
    }
}

