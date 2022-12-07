package com.my.zdemy;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ZdemyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZdemyApplication.class, args);
	}

	@Bean
	@ConfigurationProperties("app.datasource")
	public HikariDataSource dataSource() {
		return (HikariDataSource) DataSourceBuilder.create()
				.type(HikariDataSource.class).build();
	}

}
