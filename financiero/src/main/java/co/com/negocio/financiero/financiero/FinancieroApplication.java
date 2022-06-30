package co.com.negocio.financiero.financiero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan ({"co.com.negocio.financiero"})
@EntityScan("co.com.negocio.financiero")
public class FinancieroApplication {

	public static void main(String[] args) {  
		SpringApplication.run(FinancieroApplication.class, args);
	}

}
