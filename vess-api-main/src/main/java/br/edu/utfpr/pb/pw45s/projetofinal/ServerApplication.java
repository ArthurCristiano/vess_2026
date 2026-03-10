package br.edu.utfpr.pb.pw45s.projetofinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(value = {"br.edu.utfpr.pb.pw45s.projetofinal.repository", "br.edu.utfpr.pb.pw45s.projetofinal.spec"})
@EntityScan("br.edu.utfpr.pb.pw45s.projetofinal.model")
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

}
