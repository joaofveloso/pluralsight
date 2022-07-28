package com.pluralsight.springaop.flightsmanagement.introduction;

import com.pluralsight.springaop.flightsmanagement.domain.Flight;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FlyerTest {

    @Test
    public void flyerTest() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("flightsmanagement/aop.xml");

        Flight flight = (Flight) context.getBean("flight");

        context.close();
    }
}
