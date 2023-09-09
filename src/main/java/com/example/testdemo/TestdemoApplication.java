package com.example.testdemo;

import com.example.testdemo.springboot.TestApplicationHook;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Set;

@SpringBootApplication
@ImportResource("classpath:custom-editor.xml")
public class TestdemoApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(TestdemoApplication.class);
		springApplication.run(args);
//		SpringApplicationHook hook = (springApplication1) -> new TestApplicationHook();
//		SpringApplication.withHook(hook,()->{
//			springApplication.run(args);
//		});

//		SpringApplication.run(TestdemoApplication.class, args);
//		List<TestListener> list = new ArrayList<>();
//		while (true) {
//			list.add(new TestListener());
//		}
	}


	@Component
	class GetPrepareComponent implements InitializingBean {
		@Resource
		private ApplicationArguments args;


		@Override
		public void afterPropertiesSet() throws Exception {
			Set<String> optionNames = args.getOptionNames();
			for (String optionName : optionNames) {
				System.out.println(optionName);
				System.out.println(args.getOptionValues(optionName));
			}
		}
	}


	@Component
	class TestConnamdn implements ApplicationRunner {



		@Override
		public void run(ApplicationArguments args) throws Exception {
			Set<String> optionNames = args.getOptionNames();
			for (String optionName : optionNames) {
				System.out.println(optionName);
				System.out.println(args.getOptionValues(optionName));
			}
			System.out.println("args"+ Arrays.toString(args.getSourceArgs()));
		}
	}

	@Component
	class SpringApplicationRunListenerTest implements SpringApplicationRunListener {
		@Override
		public void environmentPrepared(ConfigurableBootstrapContext bootstrapContext, ConfigurableEnvironment environment) {
			System.out.println("environmentPrepared");
		}
	}


	@Component
	class 	TestProfile implements InitializingBean {
		@Resource
		private Environment environment;

		private RestTemplate restTemplate;


		@Override
		public void afterPropertiesSet() throws Exception {
			System.out.println("额外配置："+environment.getProperty("name"));
			System.out.println("p2额外配置："+environment.getProperty("p2name"));
			System.out.println("p3额外配置："+environment.getProperty("p3name"));
			System.out.println("自定义引用配置："+environment.getProperty("custome-name"));
			System.out.println("myConfig自定义引用配置："+environment.getProperty("myConfig"));
		}
	}

}
