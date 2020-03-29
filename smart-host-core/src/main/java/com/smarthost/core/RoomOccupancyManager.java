package com.smarthost.core;

import com.smarthost.core.domain.RoomType;
import com.smarthost.core.domain.RoomUsage;
import com.smarthost.core.domain.RoomUsageResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import static java.util.List.copyOf;

/**
 * the main class calculation the best room usage.
 */
public class RoomOccupancyManager {

    private static final int MIN_PREMIUM_PAYMENT = 100;
    private static final Function<List<Integer>, Integer> SUM_FUNCTION =
            list -> list.stream().mapToInt(i -> i).sum();

    private List<Integer> sortedOfferedPayments;

    public RoomOccupancyManager(final List<Integer> offeredPayments) {
        offeredPayments.sort(Collections.reverseOrder());
        sortedOfferedPayments = copyOf(offeredPayments);
    }

    /**
     * method to calculate the best room usage.
     */
    public RoomUsageResult calculate(final int premiumRoomAmount, final int economyRoomAmount) {
        var economyRooms = new ArrayList<Integer>();
        var premiumRooms = new ArrayList<Integer>();
        var remaining = sortedOfferedPayments.size();


        for (var payment : sortedOfferedPayments) {

            if (payment >= MIN_PREMIUM_PAYMENT) {
                if (roomsAvailable(premiumRooms, premiumRoomAmount)) {
                    premiumRooms.add(payment);
                }

            } else if (roomsAvailable(premiumRooms, premiumRoomAmount) && remaining > economyRoomAmount) {
                //upgrade to premium
                premiumRooms.add(payment);
            } else if (roomsAvailable(economyRooms, economyRoomAmount)) {
                economyRooms.add(payment);
            }
            remaining--;
        }

        // on big amount of data simply summing up within the loop  will perform better
        // than fancy streams (SUM_FUNCTION)
        return RoomUsageResult.create(
                RoomUsage.create(premiumRooms.size(), SUM_FUNCTION.apply(premiumRooms), RoomType.PREMIUM),
                RoomUsage.create(economyRooms.size(), SUM_FUNCTION.apply(economyRooms), RoomType.ECONOMY)
        );
    }

    private static boolean roomsAvailable(final List<Integer> roomList, final int availableRooms) {
        return roomList.size() < availableRooms;
    }
}
