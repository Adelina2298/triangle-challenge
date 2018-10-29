package org.challenge.triangle.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

/**
 * Configuration for Jackson deserialization
 * Disable conversion of float to int
 */
@Configuration
public class DeserializationConfig {
    @Bean
    public MappingJackson2HttpMessageConverter jacksonConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.ACCEPT_FLOAT_AS_INT);
        converter.setObjectMapper(mapper);
        return converter;
    }
}
