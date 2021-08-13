package br.com.blog.testlifecyclemanager;

import org.junit.ClassRule;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(initializers = { TestLifecycleManager.Initializer.class })
@ActiveProfiles("test")
@Testcontainers
public abstract class TestLifecycleManager {

	private static final String USER = "user_blog";
	private static final String PASSWORD = "1q2w3e";
	private static final String DATABASE = "blog";

	@ClassRule
	private static final DockerImageName POSTGRES_IMAGE = DockerImageName.parse("postgres:13.3-alpine");
	private static GenericContainer<?> postgresContainer = new GenericContainer<>(POSTGRES_IMAGE);

	static {
		postgresContainer.start();
    }
	
	static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
		@Override
		public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
			postgresContainer.withEnv("POSTGRES_USER", USER).withEnv("POSTGRES_PASSWORD", PASSWORD)
					.withExposedPorts(5432).withEnv("POSTGRES_DB", DATABASE);
			postgresContainer.start();

			String url = "postgresql://" + postgresContainer.getHost() + ":" + postgresContainer.getFirstMappedPort()
					+ "/" + DATABASE;

			TestPropertyValues
					.of("spring.datasource.url=" + url, "spring.datasource.username=" + USER,
							"spring.datasource.password=" + PASSWORD)
					.applyTo(configurableApplicationContext.getEnvironment());
		}
	}

}
