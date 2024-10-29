package com.lendingcatalog.model;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Movie implements CatalogItem {

    private String id;
    private String name;
    private String director;
    private LocalDate releaseDate;

    public Movie(String name, String director, LocalDate releaseDate) {
        this.name = name;
        this.director = director;
        this.releaseDate = releaseDate;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    // Implement matchesCreator
    @Override
    public boolean matchesCreator(String searchStr){
        return director != null && director.toLowerCase().contains(searchStr.toLowerCase());
    }

    // implements matchesName
    @Override
    public boolean matchesName(String searchStr){
        return name != null && name.toLowerCase().contains(searchStr.toLowerCase());
    }

    // implement matchesYear
    @Override
    public boolean matchesYear(int searchYear){
        return releaseDate != null && releaseDate.getYear() == searchYear;
    }

    // implement registerItem
    @Override
    public void registerItem(){
        this.id = UUID.randomUUID().toString();
        try (FileWriter logWriter = new FileWriter("src/main/resources/logs/movie.log", true)){
            logWriter.write(java.time.LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) +
                    " - Created: " + this.toString() + System.lineSeparator());
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "* " + name + System.lineSeparator()
                + " - Directed by: " + director + System.lineSeparator()
                + " - Released: " + releaseDate + System.lineSeparator()
                + " - Id: " + id;
    }
}
