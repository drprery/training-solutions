package week02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Office {
    private List<MeetingRoom> meetingRooms = new ArrayList<>();

    public void addMeetingRoom(MeetingRoom meetingRoom) {
        meetingRooms.add(meetingRoom);
    }

    public void printNames() {
        for (MeetingRoom mRoom : meetingRooms) {
            System.out.println(mRoom.getName());
        }
    }

    public void printNamesReverse() {
        for (int i = meetingRooms.size() - 1; i >= 0; i--) {
            System.out.println(meetingRooms.get(i).getName());
        }
    }

    public void printEvenNames() {
        for (int i = 1; i < meetingRooms.size(); i += 2) {
            System.out.println(meetingRooms.get(i).getName());
        }
    }

    public void printAreas() {
        for (MeetingRoom mRoom : meetingRooms) {
            System.out.println("A tárgyaló neve: " + mRoom.getName());
            System.out.println("A tárgyaló szélessége: " + mRoom.getWidth());
            System.out.println("A tárgyaló hosszúsága: " + mRoom.getLength());
            System.out.println("A tárgyaló területe: " + mRoom.getArea());
            System.out.println();
        }
    }

    public void printMeetingRoomsWithName(String name) {
        boolean isFound = false;

        for(MeetingRoom mRoom: meetingRooms){
            if (mRoom.getName().toLowerCase().equals(name.toLowerCase())){
                System.out.println("A keresett tárgyaló teljes neve: " + mRoom.getName());
                System.out.println("A keresett tárgyaló szélessége: " + mRoom.getWidth());
                System.out.println("A keresett tárgyaló hosszúsága: " + mRoom.getLength());
                System.out.println("A keresett tárgyaló területe: " + mRoom.getArea());
                isFound = true;
            }
        }
        if (!isFound){
            System.out.println("Nincs megfelelő nevű terem!");
        }
        System.out.println();
    }

    public void printMeetingRoomsContains(String part) {
        boolean isFound = false;

        for(MeetingRoom mRoom: meetingRooms){
            if (mRoom.getName().toLowerCase().indexOf(part.toLowerCase()) >= 0){
                System.out.println("A keresett tárgyaló teljes neve: " + mRoom.getName());
                System.out.println("A keresett tárgyaló szélessége: " + mRoom.getWidth());
                System.out.println("A keresett tárgyaló hosszúsága: " + mRoom.getLength());
                System.out.println("A keresett tárgyaló területe: " + mRoom.getArea());
                System.out.println();
                isFound = true;
            }
        }
        if (!isFound){
            System.out.println("Nincs megfelelő nevű terem!");
        }
        System.out.println();
    }

    public void printAreasLargerThan(int area) {
        for (MeetingRoom mRoom : meetingRooms) {
            if(mRoom.getArea()>area){
                System.out.println("A tárgyaló neve: " + mRoom.getName());
                System.out.println("A tárgyaló szélessége: " + mRoom.getWidth());
                System.out.println("A tárgyaló hosszúsága: " + mRoom.getLength());
                System.out.println("A tárgyaló területe: " + mRoom.getArea());
                System.out.println();
            }
        }
    }

}
