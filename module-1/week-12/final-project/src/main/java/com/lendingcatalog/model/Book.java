package com.lendingcatalog.model;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.UUID;

public class Book implements CatalogItem{

    private String id;
    private String title;
    private String author;
    private LocalDate publishDate;
    //CatalogItem interface methods;

    public Book(String title, String author, LocalDate publishDate) {
        this.title = title;
        this.author = author;
        this.publishDate = publishDate;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public boolean matchesName(String searchStr){
        return title != null && title.toLowerCase().contains(searchStr.toLowerCase());
    }

    @Override
    public boolean matchesCreator(String searchStr){
        return author != null && author.toLowerCase().contains(searchStr.toLowerCase());
    }

    @Override
    public boolean matchesYear(int searchYear){
        return publishDate != null && publishDate.getYear() == searchYear;
    }

    // Implement registerItem
    @Override
    public void registerItem(){
        this.id = UUID.randomUUID().toString();
        try (FileWriter logWriter = new FileWriter("src/main/resources/logs/book.log", true)){
            logWriter.write(java.time.LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) +
                    " - Created: " + this.toString() + System.lineSeparator());
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    // override toString() method
    @Override
    public String toString() {
        return "* " + title + System.lineSeparator()
                + " - Written by: " + author + System.lineSeparator()
                + " - Published: " + publishDate + System.lineSeparator()
                + " - Id: " + id;
    }
}
