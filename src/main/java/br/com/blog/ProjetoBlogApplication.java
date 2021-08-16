package br.com.blog;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.blog.commons.Constants;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@ComponentScan(value = Constants.PACKAGE)
@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories(Constants.PACKAGE + ".repositories") 
@EntityScan(basePackages = Constants.PACKAGE+ ".entities")
@SecurityScheme(name = "ProjetoBlogAPI", scheme = "Bearer ", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER)
public class ProjetoBlogApplication {

	public static void main(String[] args) {
		final SpringApplication application = new SpringApplication(ProjetoBlogApplication.class);
		application.setBannerMode(Banner.Mode.OFF);
		application.setWebApplicationType(WebApplicationType.SERVLET);
		application.run();
	}

}
