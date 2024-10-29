package com.techelevator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Bookkeeper {

    ArrayList<String> history = new ArrayList<>();

    ArrayList<String> dateCol = new ArrayList<>();
    ArrayList<String> typeCol = new ArrayList<>();
    ArrayList<Integer> yearCol = new ArrayList<>();
    ArrayList<Float> fromCol = new ArrayList<>();
    ArrayList<Float> toCol = new ArrayList<>();


    public void addLengthConversion(double from, double result) {
        LocalDateTime now = LocalDateTime.now();
        String entry = String.format("%s, length, %.2f, %.2f", formatTime(now), from, result);
        history.add(entry);
    }

    public void addTemperatureConversion(double from, Double result) {
        LocalDateTime now = LocalDateTime.now();
        String entry = String.format("%s, temperature, %.2f, %.2f", formatTime(now), from, result);
        history.add(entry);
    }

    void loadHistory2columns() {

        dateCol.clear();
        yearCol.clear();
        typeCol.clear();
        fromCol.clear();
        toCol.clear();;

        ArrayList<String> toImport = history;
        //ArrayList<String> toImport = MockData();

        for( String row : toImport) {

            String[] columns = row.split(",");

            dateCol.add(columns[0]);

            yearCol.add(Integer.parseInt(columns[1].trim()));
            typeCol.add(columns[2].trim());
            fromCol.add(Float.parseFloat(columns[3].trim()));
            toCol.add(Float.parseFloat(columns[4].trim()));
        }
    }

    public int getIndexOfHighestFromTemperature() {

        int highestIndex = 0;
        float highestTemp = Float.MIN_VALUE;
        for (int i = 0; i < typeCol.size(); i++) {


            String type = typeCol.get(i);

            if(type.equals("temperature")) {
                if (fromCol.get(i) > highestTemp) {
                    highestIndex = i;
                    highestTemp = fromCol.get(i);
                }
            }
        }

        return highestIndex;
    }

    public void showHighestTemperatureReport() {

        loadHistory2columns();
        int highestIndex = getIndexOfHighestFromTemperature();
        String highestRecord = String.format("Date: %s, Type: %s, From: %.2f, To: %.2f",dateCol.get(highestIndex), typeCol.get(highestIndex), fromCol.get(highestIndex), toCol.get(highestIndex));
        System.out.println("###### History record with the highest Temperature is =>" + highestRecord);

    }

    public void showAllRecords() {

        loadHistory2columns();

        for (int i = 0; i < dateCol.size(); i++) {
            String record = String.format("###### Record#:2%d, Date: %s, Type: %s, From: %.2f, To: %.2f",i, dateCol.get(i), typeCol.get(i), fromCol.get(i), toCol.get(i));
            System.out.println(record);
        }
    }

    public ArrayList<String> MockData() {

        String[] data =  new String[]{
                "16:15 Apr 24, 2022, length, 11.00, 13.28",
                "16:16 Apr 24, 2023, temperature, 33.00, -17.22",
                "16:15 Apr 24, 2022, length, 1.00, 3.28",
                "16:16 Apr 24, 2023, temperature, 23.00, -19.22",
                "16:18 Apr 24, 2025, length, 10.00, 32.80",
                "18:15 Apr 24, 2026, length, 3.00, 9.28",
                "16:14 Apr 24, 2014, temperature, 113.00, 30.78",
                "19:16 Apr 24, 2027, temperature, -3.00, -39.22",
                "16:18 Apr 24, 2025, length, 11.00, 35.80",
                "18:15 Apr 24, 2026, length, 13.00, 19.28",
                "16:14 Apr 24, 2014, temperature, 115.00, 32.78",
                "19:16 Apr 24, 2027, temperature, -31.00, -36.22",
        };

        return new ArrayList<String>(List.of(data));
    }

    String formatTime(LocalDateTime ldt) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm MMM d, yyyy");
        return ldt.format(formatter);
    }

    public void showHistoryByYear() {

        HashMap<Integer,ArrayList<String>> groupedByYear = new HashMap<>();

        for(String record : MockData())  {
            String[] columns = record.split(",");
            int year = Integer.parseInt(columns[1].trim());

            if(groupedByYear.containsKey(year)) //If we have a record for the year
            {
                groupedByYear.get(year).add(record); //append a record to this list
            }
            else // if we don't
            {
                ArrayList<String> list = new ArrayList<>();
                list.add(record);
                groupedByYear.put(year, list);
            }
        }

        ArrayList<Integer> keys = new ArrayList<>();

        for( Integer year : groupedByYear.keySet()) {
            keys.add(year);
        }

        Collections.sort(keys);

        Collections.reverse(keys);

         for(Integer year : keys) {
            System.out.println("Year " + year);
            ArrayList<String> yearArray = groupedByYear.get(year);
            for(String record : yearArray)
                System.out.println("      " + record);
            System.out.println("");
        }

        System.out.println();
        System.out.println();
        System.out.println("Future home of History by Year");
    }
}
