package com.epam.spring;

import com.epam.spring.config.BeanConfigByManual;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfigByManual.class);
		for (String beanName: context.getBeanDefinitionNames() ) {
			System.out.println(context.getBeanDefinition(beanName));
		}
		context.close();

	}

}
