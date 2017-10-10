package cad.osb.iaspr_1.rootconfigs;

import cad.osb.iaspr_1.repositories.InMemQuestionRepository;
import cad.osb.iaspr_1.repositories.QuestionRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepoConfig {
    @Bean
    public QuestionRepository questionRepository() {
        return new InMemQuestionRepository();
    }
}
