package com.smarthost.core;

import com.smarthost.core.domain.RoomType;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class RoomOccupancyManagerTest {

    private RoomOccupancyManager roomOccupancyManager = new RoomOccupancyManager(
            Arrays.asList(23, 45, 155, 374, 22, 99, 100, 101, 115, 209));


    @Test
    public void test1(){
        var result = roomOccupancyManager.calculate(3, 3);
        assertThat("room type", result.getPremium().getRoomType(), is(RoomType.PREMIUM));
        assertThat("premium used rooms", result.getPremium().getUsedRooms(), is(3));
        assertThat("premium total gain", result.getPremium().getTotalGain(), is(738));
        assertThat("room type", result.getEconomy().getRoomType(), is(RoomType.ECONOMY));
        assertThat("economy used rooms", result.getEconomy().getUsedRooms(), is(3));
        assertThat("economy total gain", result.getEconomy().getTotalGain(), is(167));
    }
    @Test
    public void test2(){
        var result = roomOccupancyManager.calculate(7, 5);
        assertThat("room type", result.getPremium().getRoomType(), is(RoomType.PREMIUM));
        assertThat("premium used rooms", result.getPremium().getUsedRooms(), is(6));
        assertThat("premium total gain", result.getPremium().getTotalGain(), is(1054));
        assertThat("room type", result.getEconomy().getRoomType(), is(RoomType.ECONOMY));
        assertThat("economy used rooms", result.getEconomy().getUsedRooms(), is(4));
        assertThat("economy total gain", result.getEconomy().getTotalGain(), is(189));
    }
    @Test
    public void test3(){
        var result = roomOccupancyManager.calculate(2, 7);
        assertThat("room type", result.getPremium().getRoomType(), is(RoomType.PREMIUM));
        assertThat("premium used rooms", result.getPremium().getUsedRooms(), is(2));
        assertThat("premium total gain", result.getPremium().getTotalGain(), is(583));
        assertThat("room type", result.getEconomy().getRoomType(), is(RoomType.ECONOMY));
        assertThat("economy used rooms", result.getEconomy().getUsedRooms(), is(4));
        assertThat("economy total gain", result.getEconomy().getTotalGain(), is(189));
    }

    @Test
    public void test4(){
        var result = roomOccupancyManager.calculate(7, 1);
        assertThat("room type", result.getPremium().getRoomType(), is(RoomType.PREMIUM));
        assertThat("premium used rooms", result.getPremium().getUsedRooms(), is(7));
        assertThat("premium total gain", result.getPremium().getTotalGain(), is(1153));
        assertThat("room type", result.getEconomy().getRoomType(), is(RoomType.ECONOMY));
        assertThat("economy used rooms", result.getEconomy().getUsedRooms(), is(1));
        assertThat("economy total gain", result.getEconomy().getTotalGain(), is(45));
    }

    @Test
    public void test5(){
        var result = roomOccupancyManager.calculate(13, 1);
        assertThat("room type", result.getPremium().getRoomType(), is(RoomType.PREMIUM));
        assertThat("premium used rooms", result.getPremium().getUsedRooms(), is(9));
        assertThat("premium total gain", result.getPremium().getTotalGain(), is(1221));

        assertThat("room type", result.getEconomy().getRoomType(), is(RoomType.ECONOMY));
        assertThat("economy used rooms", result.getEconomy().getUsedRooms(), is(1));
        assertThat("economy total gain", result.getEconomy().getTotalGain(), is(22));
    }

    @Test
    public void testNoRooms(){
        var result = roomOccupancyManager.calculate(0, 0);
        assertThat("room type", result.getPremium().getRoomType(), is(RoomType.PREMIUM));
        assertThat("premium used rooms", result.getPremium().getUsedRooms(), is(0));
        assertThat("premium total gain", result.getPremium().getTotalGain(), is(0));

        assertThat("room type", result.getEconomy().getRoomType(), is(RoomType.ECONOMY));
        assertThat("economy used rooms", result.getEconomy().getUsedRooms(), is(0));
        assertThat("economy total gain", result.getEconomy().getTotalGain(), is(0));
    }

    @Test
    public void testNoPremiumCustomer(){
        var manager = new RoomOccupancyManager(Arrays.asList(77, 3));
        var result = manager.calculate(100, 100);
        assertThat("roomType", result.getPremium().getRoomType(), is(RoomType.PREMIUM));
        assertThat("premium used rooms", result.getPremium().getUsedRooms(), is(0));
        assertThat("premium total gain", result.getPremium().getTotalGain(), is(0));

        assertThat("room type", result.getEconomy().getRoomType(), is(RoomType.ECONOMY));
        assertThat("economy used rooms", result.getEconomy().getUsedRooms(), is(2));
        assertThat("economy total gain", result.getEconomy().getTotalGain(), is(80));
    }
}