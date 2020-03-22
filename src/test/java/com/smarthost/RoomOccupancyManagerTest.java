package com.smarthost;

import com.smarthost.domain.RoomUsageResult;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class RoomOccupancyManagerTest {

    private RoomOccupancyManager roomOccupancyManager = new RoomOccupancyManager();
    //TODO parametrized tests
    @Test
    public void test1(){
        RoomUsageResult result = roomOccupancyManager.calculate(3, 3);
        assertThat(result.getPremium().getUsedRooms(), is(3));
        assertThat(result.getPremium().getTotalGain(), is(738));
        assertThat(result.getEconomy().getUsedRooms(), is(3));
        assertThat(result.getEconomy().getTotalGain(), is(167));
    }
    @Test
    public void test2(){
        RoomUsageResult result = roomOccupancyManager.calculate(7, 5);
        assertThat(result.getPremium().getUsedRooms(), is(6));
        assertThat(result.getPremium().getTotalGain(), is(1054));
        assertThat(result.getEconomy().getUsedRooms(), is(4));
        assertThat(result.getEconomy().getTotalGain(), is(189));
    }
    @Test
    public void test3(){
        RoomUsageResult result = roomOccupancyManager.calculate(2, 7);
        assertThat(result.getPremium().getUsedRooms(), is(2));
        assertThat(result.getPremium().getTotalGain(), is(583));
        assertThat(result.getEconomy().getUsedRooms(), is(4));
        assertThat(result.getEconomy().getTotalGain(), is(189));
    }

    @Test
    public void test4(){
        RoomUsageResult result = roomOccupancyManager.calculate(7, 1);
        assertThat(result.getPremium().getUsedRooms(), is(7));
        assertThat(result.getPremium().getTotalGain(), is(1153));
        assertThat(result.getEconomy().getUsedRooms(), is(1));
        assertThat(result.getEconomy().getTotalGain(), is(45));
    }

}