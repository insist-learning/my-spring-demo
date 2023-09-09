package com.example.testdemo.springboot;

import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.core.env.ConfigurableEnvironment;

public class TestListener implements SpringApplicationRunListener {

    private static final String WEBMVC_INDICATOR_CLASS = "org.springframework.web.servlet.DispatcherServlet";

    @Override
    public void environmentPrepared(ConfigurableBootstrapContext bootstrapContext, ConfigurableEnvironment environment) {
        System.out.println("prepare");
    }

    public static void main(String[] args) {
//        boolean present = ClassUtils.isPresent(WEBMVC_INDICATOR_CLASS, null);
//        System.out.println(present);


//        List<String> user = new ArrayList<>();
//        user.add("test");
//        System.out.println(user.get(0));
//        user.add(0,"testfirsti");
//        System.out.println(user.get(0));
//        System.out.println(user.get(1));
    }
}
