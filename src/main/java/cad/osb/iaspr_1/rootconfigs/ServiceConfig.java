package cad.osb.iaspr_1.rootconfigs;

import cad.osb.iaspr_1.repositories.QuestionRepository;
import cad.osb.iaspr_1.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {
    @Bean
    QuestioningService questioningService(QuestionRepository questionRepository) {
        return new QuestioningServiceImpl(questionRepository);
    }
    @Bean
    ExpertService expertService() {
        return new ExpertServiceImpl();
    }
    @Bean
    AnswerService answerService(QuestioningService questioningService) {
        return new AnswerServiceImpl(questioningService);
    }
}
