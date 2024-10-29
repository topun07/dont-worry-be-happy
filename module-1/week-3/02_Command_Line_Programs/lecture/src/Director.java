public class Director {

    UserOutput output = new UserOutput();
    UserInput input = new UserInput();

    public void startWorking() {
        output.showIAmAtWork();

        String type = input.getCOnvertionType();

        if(type.equals("l")) {
            int from = input.getLength();
            System.out.println("Entered length:" + from);

        }
        else {
            int from = input.getTemp();
            TempCoverter temp = new TempCoverter();
            Double result = temp.convertToC(from);
            output.displayTempResult(result);
        }
    }
}
