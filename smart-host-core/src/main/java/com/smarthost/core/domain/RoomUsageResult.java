package com.smarthost.core.domain;

public final class RoomUsageResult {
    private RoomUsage premium;
    private RoomUsage economy;

    private RoomUsageResult(final RoomUsage premium, final RoomUsage economy) {
        this.premium = premium;
        this.economy = economy;
    }

    public static RoomUsageResult create(final RoomUsage premium, final RoomUsage economy) {
        return new RoomUsageResult(premium, economy);
    }

    public RoomUsage getPremium() {
        return premium;
    }

    public RoomUsage getEconomy() {
        return economy;
    }

    @Override
    public String toString() {
        return "RoomUsageResult{" + "\n"
                + "premium=" + premium + ",\n"
                + "economy=" + economy
                + "\n}";
    }
}
