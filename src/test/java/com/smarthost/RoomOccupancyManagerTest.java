package com.smarthost;

import org.junit.jupiter.api.Test;

import java.util.List;

class RoomOccupancyManagerTest {

    private RoomOccupancyManager roomOccupancyManager = new RoomOccupancyManager();

    @Test
    public void test(){
        List<Integer> bookings = List.of(23, 45, 155, 374, 22, 99, 100, 101, 115, 209);
        roomOccupancyManager.calculate(bookings);
    }

}