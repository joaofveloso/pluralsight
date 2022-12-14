package com.pluralsight.springaop.flightsmanagement.config;

import com.pluralsight.springaop.flightsmanagement.domain.Flight;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class Config {

    @Bean
    public Flight flight() {
        Flight flight = new Flight();

        flight.setId("AA1234");
        flight.setCompany("ABC Flights");
        return flight;
    }
}
