package pl.sda.sdaspringtraining.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.sda.sdaspringtraining.service.mapper.CustomerMapper;

@Configuration
public class MapperConfig {

    @Bean
    CustomerMapper customerMapper() {
        return new CustomerMapper();
    }

}
