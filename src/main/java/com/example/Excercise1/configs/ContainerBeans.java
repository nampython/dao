package com.example.Excercise1.configs;

import com.example.Excercise1.utils.StringUtils;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScans({
        @ComponentScan(basePackages = "com.example.Excercise1.repository"),
        @ComponentScan(basePackageClasses = StringUtils.class),
        @ComponentScan(basePackages = "com.example.Excercise1.persistence")
})
@PropertySource("classpath:application.properties")
public class ContainerBeans {

}
