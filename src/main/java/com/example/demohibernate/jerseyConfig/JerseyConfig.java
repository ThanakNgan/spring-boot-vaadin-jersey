package com.example.demohibernate.jerseyConfig;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.util.ClassUtils;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Path;
import javax.ws.rs.ext.Provider;
import java.util.stream.Collectors;

/**
 * Created by phann on 7/26/2017.
 */
@Configuration
@ApplicationPath("api")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {

        register(JacksonFeature.class);
        ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(
                false);
        scanner.addIncludeFilter(new AnnotationTypeFilter(Provider.class));
        scanner.addIncludeFilter(new AnnotationTypeFilter(Path.class));
        this.registerClasses(
                scanner.findCandidateComponents("com.example.demohibernate").stream()
                        .map(beanDefinition -> ClassUtils.resolveClassName(
                                beanDefinition.getBeanClassName(),
                                this.getClassLoader()))
                        .collect(Collectors.toSet()));
    }

    private static ObjectMapper createDefaultMapper() {
        final ObjectMapper result = new ObjectMapper();
        result.enable(SerializationFeature.INDENT_OUTPUT);
        /*result.registerModule(new JavaTimeModule());
        result.registerModule(new MoneyModule());*/
        result.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        result.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        return result;
    }

    @Bean
    ObjectMapper objectMapper() {
        return createDefaultMapper();
    }

}