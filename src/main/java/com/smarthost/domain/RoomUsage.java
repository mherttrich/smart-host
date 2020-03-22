package com.smarthost.domain;

public class RoomUsage {
        private int usedRooms;
        private int totalGain;
        private RoomType roomType;

    private RoomUsage(int usedRooms, int totalGain, RoomType roomType) {
        this.usedRooms = usedRooms;
        this.totalGain = totalGain;
        this.roomType = roomType;
    }



    public static RoomUsage create(int usedRooms, int totalGain, RoomType roomType){
        return new RoomUsage(usedRooms,totalGain, roomType);
    }

    public int getUsedRooms() {
        return usedRooms;
    }

    public int getTotalGain() {
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
