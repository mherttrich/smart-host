package com.smarthost.web;

import com.smarthost.core.RoomOccupancyManager;
import com.smarthost.core.domain.RoomUsageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomOccupancyController {

    @Autowired
    private RoomOccupancyManager roomOccupancyManager;

    @GetMapping("/room-occupancy")
    public RoomUsageResult roomOccupancy(@RequestParam final int premiumRooms,
                                         @RequestParam final int economyRooms) {
        return roomOccupancyManager.calculate(premiumRooms, economyRooms);
    }

}
