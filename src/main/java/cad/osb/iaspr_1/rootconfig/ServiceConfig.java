package cad.osb.iaspr_1.rootconfig;

import cad.osb.iaspr_1.repository.QuestionRepository;
import cad.osb.iaspr_1.service.QuestioningService;
import cad.osb.iaspr_1.service.QuestioningServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {
    @Bean
    QuestioningService questioningService(QuestionRepository questionRepository) {
        return new QuestioningServiceImpl(questionRepository);
    }
}
