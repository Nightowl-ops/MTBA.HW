package com.ga.mbta;

public class Main {
    public static void main(String[] args) {
        MBTA mbta = new MBTA();

        int trip1 = mbta.stopsBetweenStations("Red", "Alewife", "Red", "Alewife");
        System.out.println("Alewife to Alewife: " + trip1 + " stops");

        int trip2 = mbta.stopsBetweenStations("Red", "Alewife", "Red", "South Station");
        System.out.println("Alewife to South Station: " + trip2 + " stops");

        int trip3 = mbta.stopsBetweenStations("Red", "South Station", "Green", "Kenmore");
        System.out.println("South Station to Kenmore: " + trip3 + " stops");

        int trip4 = mbta.stopsBetweenStations("Orange", "Haymarket", "Red", "Davis");
        System.out.println("Haymarket to Davis: " + trip4 + " stops");

        System.out.println("this was fun homework loved the idea of putting togeather the map and array list");
    }
}