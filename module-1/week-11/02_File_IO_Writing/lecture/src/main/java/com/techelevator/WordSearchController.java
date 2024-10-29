package com.techelevator;

import com.techelevator.util.BasicConsole;

import java.io.File;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.*;

public class WordSearchController {

    private final WordSearchView view;

    public WordSearchController(BasicConsole console) {
        view = new WordSearchView(console);
    }

    public void run() {

        // Prompt for the search path, search word, and book category
        File folderToSearch = view.promptForSearchFolder();
        String searchWord = view.promptForSearchWord();
        String category = view.promptForCategory();
        view.printBlankLine();

        //Create an empty list of Searchresults
        List<SearchResult> searchResults = new ArrayList<>();

        // Open the folder and list all the files
        File[] files = folderToSearch.listFiles();
        for(File file : files) {
            // for each file check if it is in the right category
            if(file.getName().endsWith("." + category) || category.isBlank()) {
                doSearch(file, searchWord, searchResults);
            }
        }

        view.printBlankLine();
        view.printMessage("SEARCH RESULTS");
        // Display the list of search results
        /*


1.  Alice's Adventures in Wonderland (398 occurrences of "Alice")
	  Author: Lewis Carroll
	  Category: Novel (70 pages)
	  Publisher: Macmillan
	  Year: 1865
         */
        for (int i = 0; i < searchResults.size(); i++) {
            view.printMessage((i+1) +".  ",false);
            view.printMessage(searchResults.get(i).getBook().getTitle(), false);
            view.printMessage(" (" + searchResults.get(i).getNumberOfHits() + " occurrences of \"" + searchWord + "\")",true);
        }

    }

    private void doSearch(File file, String searchWord, List<SearchResult> searchResults) {
        int occurrences = 0;
        //Open the file and read the first line
        try(Scanner inputScanner = new Scanner(file)) {

            String line = inputScanner.nextLine();
            // Split the first line by | and
            String[] bookParts = line.split("\\|");
            // convert Date Published to LocalDate
            //A Little Journey|Ray Bradbury|Galaxy Science Fiction August 1951|1951-08-01|7
            LocalDate datePublished = LocalDate.parse(bookParts[3]);
            //and #Pages to int
            int pages = Integer.parseInt(bookParts[4]);

            //Create a book object using the first line
            Book book = new Book(bookParts[0],bookParts[1],bookParts[2],datePublished,pages);

            // loop over each of the lines and check if it contains the keyword
            while(inputScanner.hasNextLine()) {
                String bookLine = inputScanner.nextLine();
                if(bookLine.contains(searchWord))
                    occurrences++;
            }

            // Create a Search Result using the book and number of hits
            SearchResult result = new SearchResult(book, getCategory(file),occurrences);
            // Add the result to the list of Search Results
            searchResults.add(result);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private String getCategory(File file) {
        String category;
        int positionOfLastDot = file.getName().lastIndexOf(".");
        String extension = file.getName().substring(positionOfLastDot + 1).toLowerCase();
        switch (extension) {
            case "collection":
                category = "Collection";
                break;
            case "novel":
                category = "Novel";
                break;
            case "story":
                category = "Story";
                break;
            default:
                category = "Unknown";
                break;
        }
        return category;
    }
}
