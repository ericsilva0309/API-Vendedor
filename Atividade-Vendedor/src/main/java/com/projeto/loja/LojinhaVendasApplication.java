package com.projeto.loja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.projeto.repository")
public class LojinhaVendasApplication {

	public static void main(String[] args) {
		SpringApplication.run(LojinhaVendasApplication.class, args);
	}

}
