package com.ga.mbta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MBTA {

    // the key of the hashmap will be the lines
    //and the arraylists will be the the order of places in each line will link each key (color to the destination accodingly)
    // we made it private because we dont want anyone to chnage anything in it it the whole program is not to add extra places its to see the number of steps
    // the mane of our hash map will be lines
// se declared an arraylist in the hashmap so when we add a key and value it will accept the arraylist with the destination

    private HashMap<String, ArrayList<String>> lines;
    // we created a constructor
    //
    public MBTA() {
        // we will initialize an empty hash map
        this.lines = new HashMap<>();


        // i thought what if we only used array it will give them in an order way but how will we know which is which color
        // it will get confusing and so everywhere
        // this is the destination for the red line
        ArrayList<String> redline = new ArrayList<>(Arrays.asList(
                "South Station", "Park Street", "Kendall", "Central",
                "Harvard", "Porter", "Davis", "Alewife"
        ));
//this is the array for the green line
        ArrayList<String> greenline = new ArrayList<>(Arrays.asList(
                "Government Center", "Park Street", "Boylston",
                "Arlington", "Copley", "Hynes", "Kenmore"
        ));
// this is the array for the orange line
        ArrayList<String> orangeline = new ArrayList<>(Arrays.asList(
                "North Station", "Haymarket", "Park Street", "State",
                "Downtown Crossing", "Chinatown", "Back Bay", "Forest Hills"
        ));
//the we match the key to the correct value now we have the color line and each there correct order of distination
        this.lines.put("Red", redline);
        this.lines.put("Green", greenline);
        this.lines.put("Orange", orangeline);
    }


    private int getstationindex(String linename, String stationname) {
        // in here we declared a vairbal called line its an empty array list then we use this.line to search for the line we wat either red or the other
        //so we enter the line and it will be retrived and put into the line Arraylist
        ArrayList<String> line = this.lines.get(linename);
        //then it will return line which is the correct road color will get the index of the stationname which were were at to get our exact location
        return line.indexOf(stationname);
    }

    //this check first if the start line and finihs line are the same distination
    //if they are the same line so it would be easy we call the get station index
    public int stopsBetweenStations(String startline, String startstation, String endline, String endstation) {
        if (startline.equalsIgnoreCase(endline)) {
            //we use these to fond the total number of steps
            // this is for when the start and final is in the same line which is easy part
            int startindex = getstationindex(startline, startstation);
            int endindex = getstationindex(endline, endstation);
            // in some situation we might get a negative number so we added an absoulte to deal with it
            return Math.abs(startindex - endindex);
        }
//will get the idex of the distincation betweenthe line and park street because it is the only connector to the each of the line
        // these are the only two scenarios we need to deal with
        // there on the same line
        //there in different lines (connection is park street)
        // from the start to parkk street
        // then from end line to to park street
        // then we add them
        int startindex = getstationindex(startline, startstation);
        int parkstartlineindex = getstationindex(startline, "Park Street");
        int leg1 = Math.abs(startindex - parkstartlineindex);

        int parkendlineindex = getstationindex(endline, "Park Street");
        int endindex = getstationindex(endline, endstation);
        int leg2 = Math.abs(parkendlineindex - endindex);

        return leg1 + leg2;
    }
}