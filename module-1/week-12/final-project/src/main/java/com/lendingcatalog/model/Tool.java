package com.lendingcatalog.model;

import java.io.FileWriter;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.UUID;
import java.io.IOException;

public class Tool implements CatalogItem{

    private String id;
    private String type;
    private String manufacturer;
    private int count;

   //constructor
    public Tool(String type, String manufacturer, int count) {
        this.type = type;
        this.manufacturer = manufacturer;
        this.count = count;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    // implements matchesName
    @Override
    public boolean matchesName(String searchStr){
        return type != null && type.toLowerCase().contains(searchStr.toLowerCase());
    }

    //Implement matchesCreator
    @Override
    public boolean matchesCreator(String searchStr){
        return manufacturer != null && manufacturer.toLowerCase().contains(searchStr.toLowerCase());
    }

    //implements matchesYear()
    @Override
    public boolean matchesYear(int searchYear){
        return false; // tool has no year field, so this method always returns false
    }

    //implement registerItem()
    @Override
    public void registerItem(){
        this.id = UUID.randomUUID().toString();
        try (FileWriter logWriter = new FileWriter("src/main/resources/logs/tool.log", true)){
            logWriter.write(java.time.LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) +
                    " - Created: " + this.toString() + System.lineSeparator());
        } catch (IOException e){
            e.printStackTrace();
        }
    }

   // override toString() Method
    @Override
    public String toString() {
        return "* " + type + System.lineSeparator()
                + " - Manufactured by: " + manufacturer + System.lineSeparator()
                + " - Count: " + count + System.lineSeparator()
                + " - Id: " + id;
    }
}

