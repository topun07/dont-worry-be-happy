/* This project just about drove me insane. Im so tired of looking at code
   My thoughts will forever be tormented */


package com.techelevator;

import java.math.BigDecimal;
import java.util.*;
import java.util.List;
import java.util.ArrayList;

public class App {

    // The regex string to split the Strings in the dataset.
    private static final String FIELD_DELIMITER = "\\|";

    private static final int TITLE_FIELD = 0;
    private static final int AUTHOR_FIELD = 1;
    private static final int PUBLISHED_YEAR_FIELD = 2;
    private static final int PRICE_FIELD = 3;

    private final Scanner keyboard = new Scanner(System.in);

    private List<String> titles = new ArrayList<>();
    private List<String> authors = new ArrayList<>();
    private List<Integer> publishedYears = new ArrayList<>();
    private List<BigDecimal> prices = new ArrayList<>();

    public static void main(String[] args) {

        App app = new App();
        app.loadData();
        app.run();

    }

    private void loadData() {

        String[] dataset = Dataset.load();

        for (String data : dataset) { //requirement 1
            String[] fields = data.split(FIELD_DELIMITER); // seperates columns
            if (fields.length == 4) {
                titles.add(fields[0]);
                authors.add(fields[1]);
                publishedYears.add(Integer.parseInt(fields[2]));
                prices.add(new BigDecimal(fields[3]));
            } else {
                System.out.println("Invalid data format: " + data);
            }
        }
    }

    private void run() {

        while (true) {
            // Main menu loop
            printMainMenu();
            int mainMenuSelection = promptForMenuSelection("Please choose an option: ");
            if (mainMenuSelection == 1) {
                // Display data and subsets loop
                while (true) {
                    printDataAndSubsetsMenu();
                    int dataAndSubsetsMenuSelection = promptForMenuSelection("Please choose an option: ");
                    if (dataAndSubsetsMenuSelection == 1) {
                        displayDataset(Dataset.load());
                    } else if (dataAndSubsetsMenuSelection == 2) {
                        filterByTitle(titles);
                    } else if (dataAndSubsetsMenuSelection == 3) {
                        displayAuthorsList(authors);
                    } else if (dataAndSubsetsMenuSelection == 4) {
                        displayPublishedYearsList(publishedYears);
                    } else if (dataAndSubsetsMenuSelection == 5) {
                        displayPricesList(prices);
                    } else if (dataAndSubsetsMenuSelection == 0) {
                        break;
                    }
                }
            } else if (mainMenuSelection == 2) {
                while (true) {
                    printSearchBooksMenu();
                    int searchBooksMenuSelection = promptForMenuSelection("Please choose an option: ");
                    if (searchBooksMenuSelection == 1) {
                        String filterTitle = promptForString("Enter title: ");
                        List<Integer> indexes = new ArrayList<>(filterByTitle(filterTitle));
                        displaySearchResults(indexes);

                    } else if (searchBooksMenuSelection == 2) {
                        String filterAuthor = promptForString("Enter author: ");
                        List<Integer> indexes = new ArrayList<>(filterByAuthor(filterAuthor));
                        displaySearchResults(indexes);

                    } else if (searchBooksMenuSelection == 3) {
                        int filterYear = promptForPublishedYear("Enter date: (YYYY): ");
                        List<Integer> indexes = new ArrayList<>(filterByPublishedYear(filterYear));
                        displaySearchResults(indexes);

                    } else if (searchBooksMenuSelection == 4) {
                        int filterFromYear = promptForPublishedYear("Enter \"from\" date (YYYY): ");
                        int filterToYear = promptForPublishedYear("Enter \"to\" date (YYYY): ");
                        List<Integer> indexes = new ArrayList<>(filterByPublishedYearRange(filterFromYear, filterToYear));
                        displaySearchResults(indexes);

                    } else if (searchBooksMenuSelection == 5) {
                        int findMostRecentBooks = promptForPublishedYear("Enter date: (YYYY)");
                        List<Integer> indexes = new ArrayList<>(filterByPublishedYear(findMostRecentBooks));
                        displaySearchResults(indexes);

                    } else if (searchBooksMenuSelection == 6) {
                        double filterPrice = promptForPrice("Enter price: ");
                        List<Integer> indexes = new ArrayList<>(filterByPrice(filterPrice));
                        displaySearchResults(indexes);

                    } else if (searchBooksMenuSelection == 7) {
                        double filterFromPrice = promptForPrice("Enter \"from\" price: ");
                        double filterToPrice = promptForPrice("Enter \"to\" price: ");
                        displaySearchResults(filterByPriceRange(filterFromPrice, filterToPrice));

                    } else if (searchBooksMenuSelection == 8) {
                        List<Integer> indexes = new ArrayList<>(findLeastExpensiveBooks());
                        displaySearchResults(indexes);

                    } else if (searchBooksMenuSelection == 0) {
                        break;
                    }
                }
            } else if (mainMenuSelection == 0) {
                break;
            }
        }
    }


    private void displaySearchResults(List<Integer> indexes) {
        for (int index : indexes) {
            if (index >= 0 && index < titles.size()) {
                String title = titles.get(index);
                String author = authors.get(index);
                int year = publishedYears.get(index);
                BigDecimal price = prices.get(index);

                System.out.printf("%s: %s: %d: $%.2f%n", title, author, year, price);
            } else {
                System.out.println("Invalid index: " + index);
            }
        }
    }

    private List<Integer> filterByTitle(String filterTitle) {
        List<Integer> indexes = new ArrayList<>();
        String title = filterTitle.toLowerCase();

        for (int i = 0; i < titles.size(); i++) {
            String titleResult = titles.get(i);
            if (titleResult.contains(title)) {
                indexes.add(i);
            }
        }
        return indexes;
    }

    private List<Integer> filterByAuthor(String filterAuthor) {
        List<Integer> indexes = new ArrayList<>();
        String filter = filterAuthor.toLowerCase();

        boolean found = false; // tracking matching authors if found

        for (int i = 0; i < authors.size(); i++) {
            String author = authors.get(i);
            String[] parts = author.split("\\s+"); // split author name into parts
            String firstName = parts[0].toLowerCase();
            String lastName = parts[parts.length - 1].toLowerCase();

            if (firstName.contains(filter) || lastName.contains(filter)) {
                indexes.add(i);
                found = true;
            }
        }
        if (!found) {
            indexes.add(-1); // add -1 if author not found
        }
        return indexes;
    }

    private List<Integer> filterByPublishedYear(int filterYear) {
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < publishedYears.size(); i++) {
            if (publishedYears.get(i) == filterYear) {
                indexes.add(i);
            }
        }
        return indexes;
    }

    private List<Integer> filterByPublishedYearRange(int filterFromYear, int filterToYear) {
        //method for filtering published year range
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < publishedYears.size(); i++) {
            int year = publishedYears.get(i);
            if (year >= filterFromYear && year <= filterToYear) {
                indexes.add(i);
            }
        }
        return indexes;
    }

    private List<Integer> findMostRecentBooks(int latestYear) { /*if there are multiple books in the same year listed all
        should be listed */
        List<Integer> indexes = new ArrayList<>();
        //int maxYear = Integer.MIN_VALUE;
        //boolean found = false; //track if input year matches whats in our database
        if (!publishedYears.isEmpty()) {
            int lateYear = Integer.MIN_VALUE;

            for (Integer year : publishedYears) {
                if (year > latestYear) {
                    lateYear = year;
                }
            }
            for (int i = 0; i < publishedYears.size(); i++) {
                if (publishedYears.get(i) == lateYear) {
                    indexes.add(i);
                }
            }
        /*for (int i = 0; i < publishedYears.size(); i++) {
            int year = publishedYears.get(i);
            if (year > maxYear) {
                maxYear = year;
                //indexes.clear();
                indexes.add(i);
                found = true; // true if book is found
            } else if (year == maxYear) {
                indexes.add(i);
                found = true; // true if book is found
            }
        }
        if (!found) { // -1 if not found
            //indexes.clear(); // clear any existing indexes
            indexes.add(-1);*/
        }
        return indexes;
    }

    private List<Integer> filterByPrice(double filterPrice) {
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < prices.size(); i++) {
            if (prices.get(i).doubleValue() == filterPrice) {
                indexes.add(i);
            }
        }
        return indexes;
}

    private List<Integer> filterByPriceRange(double filterFromPrice, double filterToPrice) {
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < prices.size(); i++){
            double price = prices.get(i).doubleValue();
            if (price >= filterFromPrice && price <= filterToPrice){
                indexes.add(i);
            }
        }
        return indexes;
    }

    private List<Integer> findLeastExpensiveBooks(){
        List<Integer> indexes = new ArrayList<>();
        BigDecimal minPrice = Collections.min(prices);
        for (int i = 0; i < prices.size(); i++) {
            if (prices.get(i).compareTo(minPrice) == 0){ // compareTo works with BigDecimal as opposed to equals
                indexes.add(i);
            }
        }
        return indexes;
        }


    // UI methods

    private void printMainMenu() {
        System.out.println("1: Display data and subsets");
        System.out.println("2: Search books");
        System.out.println("0: Exit");
        System.out.println();
    }

    private void printDataAndSubsetsMenu() {
        System.out.println("1: Display dataset");
        System.out.println("2: Display titles");
        System.out.println("3: Display authors");
        System.out.println("4: Display published years");
        System.out.println("5: Display prices");
        System.out.println("0: Return to main menu");
        System.out.println();
    }

    private void printSearchBooksMenu() {
        System.out.println("1: Search by title");
        System.out.println("2: Search by author");
        System.out.println("3: Search by published year");
        System.out.println("4: Search by published year range");
        System.out.println("5: Find most recent books");
        System.out.println("6: Search by price");
        System.out.println("7: Search by price range");
        System.out.println("8: Find least expensive books");
        System.out.println("0: Return to main menu");
        System.out.println();
    }

    private void displayDataset(String[] dataset) {
        System.out.println("Dataset");
        System.out.println("-------");
        for (String data : dataset) {
            System.out.println(data);
        }
        System.out.println();
        promptForReturn();
    }

    private void filterByTitle(List<String> titles) {
        System.out.println("Titles");
        System.out.println("-------");
        for (int i = 0; i < titles.size(); i++) {
            System.out.println(i + ": " + titles.get(i));
        }
        System.out.println();
        promptForReturn();
    }

    private void displayAuthorsList(List<String> authors) {
        System.out.println("Authors");
        System.out.println("-------");
        for (int i = 0; i < authors.size(); i++) {
            System.out.println(i + ": " + authors.get(i));
        }
        System.out.println();
        promptForReturn();
    }

    private void displayPublishedYearsList(List<Integer> publishedYears) {
        System.out.println("Published Years");
        System.out.println("---------------");
        for (int i = 0; i < publishedYears.size(); i++) {
            System.out.println(i + ": " + publishedYears.get(i));
        }
        System.out.println();
        promptForReturn();
    }

    private void displayPricesList(List<BigDecimal> prices) {
        System.out.println("Prices");
        System.out.println("------");
        for (int i = 0; i < prices.size(); i++) {
            System.out.println(i + ": " + prices.get(i));
        }
        System.out.println();
        promptForReturn();
    }

    private int promptForMenuSelection(String prompt) {
        System.out.print(prompt);
        int menuSelection;
        try {
            menuSelection = Integer.parseInt(keyboard.nextLine());
        } catch (NumberFormatException e) {
            menuSelection = -1;
        }
        return menuSelection;
    }

    private String promptForString(String prompt) {
        System.out.print(prompt);
        return keyboard.nextLine();
    }

    private int promptForPublishedYear(String prompt) {
        int year;
        while (true) {
            System.out.println(prompt);
            try {
                year = Integer.parseInt(keyboard.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("The year provided is not well-formed. It must be YYYY.");
            }
        }
        return year;
    }

    private double promptForPrice(String prompt) {
        double price;
        while (true) {
            System.out.println(prompt);
            try {
                price = Double.parseDouble(keyboard.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("The price provided is not a valid monetary value.");
            }
        }
        return price;
    }

    private void promptForReturn() {
        System.out.println("Press RETURN to continue.");
        keyboard.nextLine();
    }
}
