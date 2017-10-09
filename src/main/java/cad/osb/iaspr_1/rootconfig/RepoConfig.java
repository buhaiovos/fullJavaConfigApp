package cad.osb.iaspr_1.rootconfig;

import cad.osb.iaspr_1.repository.InMemQuestionRepository;
import cad.osb.iaspr_1.repository.QuestionRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepoConfig {
    @Bean
    public QuestionRepository questionRepository() {
        return new InMemQuestionRepository();
    }
}
