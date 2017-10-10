package cad.osb.iaspr_1.webconfig;

import cad.osb.iaspr_1.controllers.ExpertConverter;
import cad.osb.iaspr_1.controllers.QuestionConverter;
import cad.osb.iaspr_1.controllers.QuestioningController;
import cad.osb.iaspr_1.services.ExpertService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = QuestioningController.class)
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver =
                new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new ExpertConverter());
        registry.addConverter(new QuestionConverter());
    }

}
