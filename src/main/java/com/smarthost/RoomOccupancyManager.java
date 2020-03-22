package com.smarthost;

import com.smarthost.domain.RoomType;
import com.smarthost.domain.RoomUsage;
import com.smarthost.domain.RoomUsageResult;

import java.util.*;

public class RoomOccupancyManager {


    private boolean roomsAvailable(List<Integer> roomList, int availableRooms) {
        return roomList.size() < availableRooms;
    }

    public RoomUsageResult calculate(int premiumRooms, int economyRooms) {
        var eco = new ArrayList<Integer>();
        var prem = new ArrayList<Integer>();


        //TODO read from JSON config
        var reservations = List.of(23, 45, 155, 374, 22, 99, 100, 101, 115, 209);
        //(reservations.stream().sorted(Collections.reverseOrder())).forEach(System.out::println);

        Queue<Integer> offeredPayments = new PriorityQueue<>(Comparator.reverseOrder());
        offeredPayments.addAll(reservations);

        while (!offeredPayments.isEmpty()) {
            var payment = offeredPayments.poll();
            var isPremiumPayment = payment >= 100;

            if (isPremiumPayment) {
                if (roomsAvailable(prem, premiumRooms)) {
                    prem.add(payment);
                }

            } else if (roomsAvailable(prem, premiumRooms) && offeredPayments.size() >= economyRooms) {
                //upgrade to premium
                prem.add(payment);
            } else if (roomsAvailable(eco, economyRooms)) {
                eco.add(payment);
            }
        }

        return RoomUsageResult.create(
                RoomUsage.create(prem.size(), prem.stream().mapToInt(i -> i).sum(), RoomType.PREMIUM),
                RoomUsage.create(eco.size(), eco.stream().mapToInt(i -> i).sum(), RoomType.ECONOMY)
        );
    }
}
