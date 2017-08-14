package demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoFwSamplesSimpleApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoFwSamplesSimpleApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(@Value("${spring.messages.basename}") String basename,
			MessageSource messageSource) {
		return x -> {
			System.out.println(basename);
			System.out.println(messageSource.getMessage("demo.core", null, null));
			System.out.println(messageSource.getMessage("demo.web", null, null));
			System.out.println(messageSource.getMessage("demo.messages", null, null));
		};
	}
}
