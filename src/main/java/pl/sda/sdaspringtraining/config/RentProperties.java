package pl.sda.sdaspringtraining.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "rent")
public class RentProperties {

    private Integer maxDaysPerRent = 0;
    private Integer maxRentsPerUser = 0;
    private Integer minDaysOfRent = 0;

}
