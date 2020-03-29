package com.smarthost.web;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class YMLConfiguration {

    private List<Integer> bookings = new ArrayList<>();

    /**
     *
     * @return the list of all bookings configured in application.yml
     */
    public List<Integer> getBookings() {
        return bookings;
    }
}
