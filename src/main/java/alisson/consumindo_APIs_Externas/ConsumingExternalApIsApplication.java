package alisson.consumindo_APIs_Externas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ConsumingExternalApIsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumingExternalApIsApplication.class, args);
	}

}
