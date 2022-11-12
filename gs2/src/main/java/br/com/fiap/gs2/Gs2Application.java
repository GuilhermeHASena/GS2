package br.com.fiap.gs2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"br.com.fiap.gs2.controllers, br.com.fiap.gs2.config"})
public class Gs2Application {

	public static void main(String[] args) {
		SpringApplication.run(Gs2Application.class, args);
	}

}
