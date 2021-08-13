package br.com.blog;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(value = Constants.PACKAGE)
@EnableAutoConfiguration
@SpringBootApplication
public class ProjetoBlogApplication {

	public static void main(String[] args) {
		final SpringApplication application = new SpringApplication(ProjetoBlogApplication.class);
		application.setBannerMode(Banner.Mode.OFF);
		application.run();
	}

}
