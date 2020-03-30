package com.smarthost.core.domain;

public final class RoomUsage {
        private Integer usedRooms;
        private Integer totalGain;
        private RoomType roomType;

    private RoomUsage(final Integer usedRooms, final Integer totalGain, final RoomType roomType) {
        this.usedRooms = usedRooms;
        this.totalGain = totalGain;
        this.roomType = roomType;
    }

    /**
     * static factory method.
     */
    public static RoomUsage create(final Integer usedRooms, final Integer totalGain, final RoomType roomType) {
        return new RoomUsage(usedRooms, totalGain, roomType);
    }

    public Integer getUsedRooms() {
        return usedRooms;
    }

    public Integer getTotalGain() {
        return totalGain;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    @Override
    public String toString() {
        return "RoomUsage{"
                + "usedRooms=" + usedRooms
                + ", totalGain=" + totalGain
                + ", roomType=" + roomType
                + '}';
    }
}
