package br.com.blog.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;

@Configuration
public class LocalDateTimeConfig {

    @Bean
    public LocalDateTime localDateTime() {
        return LocalDateTime.now();
    }
}
