package com.smarthost.web;

import com.smarthost.core.RoomOccupancyManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfiguration {

    @Autowired
    private YmlConfiguration ymlConfiguration;

    @Bean
    public RoomOccupancyManager getRoomOccupancyManager() {
        return new RoomOccupancyManager(ymlConfiguration.getBookings());
    }

}
