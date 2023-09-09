package com.example.testdemo.springboot;

import com.example.testdemo.TestdemoApplication;
import org.springframework.boot.*;

public class TestApplicationHook implements SpringApplicationRunListener {


    @Override
    public void starting(ConfigurableBootstrapContext bootstrapContext) {
        System.out.println("通过钩子触发listener");
    }

    // 使用钩子启动 spring 应用
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(new Class[]{TestdemoApplication.class});
        SpringApplicationHook hook = (sp) -> new TestApplicationHook();
        SpringApplication.withHook(hook,()->{
            springApplication.run(args);
        });

//		SpringApplication.run(TestdemoApplication.class, args);
//		List<TestListener> list = new ArrayList<>();
//		while (true) {
//			list.add(new TestListener());
//		}
    }
}
