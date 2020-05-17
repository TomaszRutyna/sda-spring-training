package pl.sda.sdaspringtraining;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import pl.sda.sdaspringtraining.config.RentProperties;

@EnableConfigurationProperties({RentProperties.class})
@SpringBootApplication
public class SdaSpringTrainingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SdaSpringTrainingApplication.class, args);
    }
}
