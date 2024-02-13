package jaeger.de.miel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloWorldApiApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(HelloWorldApiApplication.class);
		app.run(args);
	}

// List all Beans
//	@Bean
//	public CommandLineRunner run(ApplicationContext appContext) {
//		return args -> {
//			String[] beans = appContext.getBeanDefinitionNames();
//			Arrays.stream(beans).sorted().forEach(System.out::println);
//		};
//	}

}
