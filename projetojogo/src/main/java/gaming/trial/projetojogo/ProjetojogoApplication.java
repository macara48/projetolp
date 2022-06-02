package gaming.trial.projetojogo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.example.demo", "controller", "service"})
public class ProjetojogoApplication {

	public static void main(String[] args) {

		SpringApplication.run(ProjetojogoApplication.class, args);
	}

}
