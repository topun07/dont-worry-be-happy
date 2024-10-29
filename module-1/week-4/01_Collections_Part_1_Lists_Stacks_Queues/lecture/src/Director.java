public class Director {

    UserOutput output = new UserOutput();
    UserInput input = new UserInput();

    public void startWorking() {
        output.openForBusiness();
        Bookkeeper history = new Bookkeeper();
        /*ArrayList<String> names = new ArrayList<>();
        {
            names.add("Frodo");
            names.add('Sam');
            names.add('Pete');
            names.add('Paul');
            names.add('ile');
        }*/



        while (true) {

            String type = input.getConvesionType();

            if(type.equals("l")) {
                double from = input.getLength();
                LengthConverter lc = new LengthConverter();
                Double result = lc.convertToFeet(from);
                output.displayLengthResult(result);
                history.addLengthConversion(from, result);
            }
            else {
                double from = input.getTemp();
                TempCoverter temp = new TempCoverter();
                Double result = temp.convertToCelsius(from);
                output.displayTempResult(result);
                history.addTemperatureConversion(from, result);
            }

            System.out.println(history.getReport());
        }
    }
}
