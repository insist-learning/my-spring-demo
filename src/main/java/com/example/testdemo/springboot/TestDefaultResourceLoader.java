package com.example.testdemo.springboot;

import lombok.SneakyThrows;

import org.assertj.core.api.Assertions;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

public class TestDefaultResourceLoader {

    @SneakyThrows
    public static void main(String[] args) {
        DefaultResourceLoader defaultResourceLoader = new DefaultResourceLoader();
        Resource resource = defaultResourceLoader.getResource("classpath:/application.yml");
        System.out.println(resource.exists());
        System.out.println(resource.isFile());
        System.out.println(resource.getFilename());
        System.out.println(resource.isReadable());
        System.out.println(resource.lastModified());
        if (resource instanceof ClassPathResource resource1) {
            System.out.println(resource1.getURL());
        }
        User user = new User();

     }
}
