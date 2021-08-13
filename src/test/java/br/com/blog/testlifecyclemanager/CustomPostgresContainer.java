package br.com.blog.testlifecyclemanager;

import org.testcontainers.containers.PostgreSQLContainer;

public class CustomPostgresContainer extends PostgreSQLContainer {

	private static final String IMAGE_VERSION = "postgres:13.3-alpine";
	private static CustomPostgresContainer container;

	private CustomPostgresContainer() {
		super(IMAGE_VERSION);
	}

	public static CustomPostgresContainer getInstance() {
		if (container == null) {
			container = new CustomPostgresContainer();
		}
		return container;
	}

	@Override
	public void start() {
		super.start();
		System.setProperty("DB_URL", container.getJdbcUrl());
		System.setProperty("DB_USER", container.getUsername());
		System.setProperty("DB_PASSWORD", container.getPassword());
	}

	@Override
	public void stop() {
		super.stop();
	}

}
