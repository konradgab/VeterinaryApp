package pl.gr.veterinaryapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;
import java.time.LocalDateTime;

@Configuration
public class VetAppConfig {

    @Bean
    public Clock systemClock() {
        return Clock.systemUTC();
    }

}
