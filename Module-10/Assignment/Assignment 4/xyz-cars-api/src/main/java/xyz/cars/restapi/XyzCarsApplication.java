package xyz.cars.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import xyz.cars.restapi.config.AppProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class XyzCarsApplication {

	public static void main(String[] args) {
		SpringApplication.run(XyzCarsApplication.class, args);
	}

}
