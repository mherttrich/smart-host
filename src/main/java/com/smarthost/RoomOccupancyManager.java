package com.smarthost;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RoomOccupancyManager {


    private int premiumRoomCount = 5;
    private int economyRoomCount = 10;
    private List<Integer> eco = new ArrayList<>();
    private List<Integer> prem = new ArrayList<>();

    private boolean isPremiumFull() {
        return prem.size() >= premiumRoomCount;
    }

    private boolean isEconomyFull() {
        return eco.size() >= economyRoomCount;
    }

    public void calculate(List<Integer> reservations) {
        reservations
                .stream()
                .sorted(Comparator.reverseOrder()).forEach(payment -> {

            boolean isPremiumPayment = payment >= 100;

            if (!isPremiumFull() && isPremiumPayment) {
                prem.add(payment);
            } else if (!isPremiumFull()) { //remaining customer exeeds size of eco
                //upgrade customer
                prem.add(payment);
            } else if (!isEconomyFull() && !isPremiumPayment) {
                eco.add(payment);
            }
        });

        System.out.println("prem:" + prem + "  " + prem.stream().mapToInt(i -> i).sum());
        System.out.println("eco:" + eco + "  " + eco.stream().mapToInt(i -> i).sum());
    }
}
