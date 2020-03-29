package com.smarthost.web;

import com.smarthost.core.RoomOccupancyManager;
import com.smarthost.core.domain.RoomType;
import com.smarthost.core.domain.RoomUsage;
import com.smarthost.core.domain.RoomUsageResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RoomOccupancyController.class)
public class RoomOccupancyWebMockTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RoomOccupancyManager manager;

    @Test
    public void shouldInvokeRoomOccupancyManager() throws Exception {
        RoomUsageResult roomUsageResult = RoomUsageResult.create(
                RoomUsage.create(1, 110, RoomType.PREMIUM),
                RoomUsage.create(3, 75, RoomType.ECONOMY)
        );

        when(manager.calculate(1, 3))
                .thenReturn(roomUsageResult);

        this.mockMvc.perform(get("/room-occupancy")
                .param("premiumRooms", "1")
                .param("economyRooms", "3"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.premium.usedRooms", is(1)))
                .andExpect(jsonPath("$.premium.totalGain", is(110)))
                .andExpect(jsonPath("$.economy.usedRooms", is(3)))
                .andExpect(jsonPath("$.economy.totalGain", is(75)));
    }
}
