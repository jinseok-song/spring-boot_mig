package net.appspeed.studio;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;

@EnableCaching
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class Application {

	
	public static void main(String[] args) {
		new SpringApplicationBuilder(Application.class).run(args);

		System.out.println("Let's inspect the beans provided by Spring Boot:");
	
//
//		String[] beanNames = ctx.getBeanDefinitionNames();
//		Arrays.sort(beanNames);
//		for (String beanName : beanNames) {
//			System.out.println(beanName);
//
//		}
	
		
		
	}
	
 
}
