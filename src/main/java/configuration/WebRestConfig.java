package configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import entities.LocalDateTimeFormatter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.format.Formatter;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Configuration
public class WebRestConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper().
                registerModule(new JavaTimeModule())
                .setAnnotationIntrospector(new JacksonAnnotationIntrospector())
                .setDateFormat(new StdDateFormat())
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
//        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
//        .configure(MapperFeature.DEFAULT_VIEW_INCLUSION, true);
//        return mapper;
    }


    @Bean
    @Primary
    public Formatter<LocalDateTime> localDateTimeFormatter() {
        return new LocalDateTimeFormatter();
    }
}

