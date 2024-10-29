package com.techelevator;

public class Director {

    UserOutput output = new UserOutput();
    UserInput input = new UserInput();
    Bookkeeper history = new Bookkeeper();

    public void startWorking() {
        output.openForBusiness();

        while (true) {

            int choice = input.displayMainMenu();

            if(choice == 1)
                goToConversions();
            else if(choice == 2)
                goToReports();
            else {
                output.sayGoodBye();
                return;
            }
        }
    }

    private void goToReports() {

        while (true) {

            int choice = input.displayReportMenu();

            if(choice == 1)
                history.showAllRecords();
            else if(choice == 2)
                history.showHighestTemperatureReport();
            else {
                return;
            }
        }
    }

    private void goToConversions() {

        while(true) {
            String type = input.getConversionType();

            if (type.equals("l")) {
                double from = input.getLength();
                LengthConverter lc = new LengthConverter();
                Double result = lc.convertToFeet(from);
                output.displayLengthResult(result);
                history.addLengthConversion(from, result);
            } else if(type.equals("t")){
                double from = input.getTemp();
                TempCoverter temp = new TempCoverter();
                Double result = temp.convertToCelsius(from);
                output.displayTempResult(result);
                history.addTemperatureConversion(from, result);
            }
            else
                return;
        }
    }
}
