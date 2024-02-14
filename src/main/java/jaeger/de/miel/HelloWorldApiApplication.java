package jaeger.de.miel;

import jaeger.de.miel.filters.ResponseLoggingFilter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class HelloWorldApiApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(HelloWorldApiApplication.class);
		app.run(args);
	}


	@Bean
	// List all Beans
	public CommandLineRunner run(ApplicationContext appContext) {
		return args -> {
			String[] beans = appContext.getBeanDefinitionNames();
			Arrays.stream(beans).sorted().forEach(System.out::println);
		};
	}

	@Bean
	public FilterRegistrationBean<ResponseLoggingFilter> responseLoggingFilterRegistration() {
		FilterRegistrationBean<ResponseLoggingFilter> registration = new FilterRegistrationBean<>();
		registration.setFilter(new ResponseLoggingFilter());
		registration.addUrlPatterns("/*");
		registration.setOrder(1);
		return registration;
	}


}
