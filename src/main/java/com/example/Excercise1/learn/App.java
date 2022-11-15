package com.example.Excercise1.learn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyAppConfig.class);
        StringUtilv1 stringUtilv1 = applicationContext.getBean(StringUtilv1.class);

        Human human = new People("A", 20);
    }
}
