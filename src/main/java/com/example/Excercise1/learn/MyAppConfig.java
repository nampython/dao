package com.example.Excercise1.learn;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyAppConfig {

    @Bean
    public StringUtilv1 getStringUtilv1() {
        return new StringUtilv1Impl();
    }
}
