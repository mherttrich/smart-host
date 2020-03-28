package com.smarthost.core.domain;

public class RoomUsage {
        private Integer usedRooms;
        private Integer totalGain;
        private RoomType roomType;

    private RoomUsage(Integer usedRooms, Integer totalGain, RoomType roomType) {
        this.usedRooms = usedRooms;
        this.totalGain = totalGain;
        this.roomType = roomType;
    }



    public static RoomUsage create(Integer usedRooms, Integer totalGain, RoomType roomType){
        return new RoomUsage(usedRooms,totalGain, roomType);
    }

    public Integer getUsedRooms() {
        return usedRooms;
    }

    public Integer getTotalGain() {
        return totalGain;
    }

    //TODO
    public RoomType getRoomType() {
        return roomType;
    }

    @Override
    public String toString() {
        return "RoomUsage{" +
                "usedRooms=" + usedRooms +
                ", totalGain=" + totalGain +
                ", roomType=" + roomType +
                '}';
    }
}
