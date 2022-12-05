package com.example.Excercise1.enviroments;

import java.io.*;
import java.nio.file.Files;
import java.util.Properties;
import org.springframework.util.ResourceUtils;


public class EnvironmentConfiguration  {
    public static Properties properties() {
        Properties properties = new Properties();
        try {
            File file = ResourceUtils.getFile("classpath:application.properties");
            InputStream in = Files.newInputStream(file.toPath());
            properties.load(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }
}
