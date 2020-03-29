package com.smarthost.web;

import com.smarthost.core.RoomOccupancyManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@Configuration
public class MainConfiguration {

    @Autowired
    private YMLConfiguration ymlConfiguration;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Bean
    public RoomOccupancyManager getRoomOccupancyManager() {
        return new RoomOccupancyManager(ymlConfiguration.getBookings());
    }

    @Bean
    MockMvc getMockMvc(){
        return MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();

    }
}
