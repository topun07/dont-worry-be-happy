public class Main {
    public static void main(String[] args) {

        int someVariableName = sum(5,8);

        int b;

        int a = 5;

        int[] type0; //Declare ONLY!
        int[] type1 = new int[4]; //Declare and initialize
        int[] type2 = new int[] {1,3,5,7,9}; //declare and initialize
        int[] type3 = {2,4,6,8,10}; //declare and initialize


        String[] fruit = new String[4];
        fruit[0] = "Apple";
        fruit[1] = "Orange";
        fruit[2] = "Banana";
        fruit[3] = "Pear";

        String[] animals = {"dog","fish", "horse"};


        for (int index = 0; index < fruit.length; index+=2) {
            System.out.println(fruit[index]);
        }

        animals[1] = "dragon";

        //animals[3] = "bird";

        //int squared = square(someVariableName);

        System.out.println("The Square IS:" + someVariableName);

        //System.out.println("The SQUARE IS:" + squared);
    }

    public static int sum(int first, int second) {

        int s= first + second;
        int sq = square(s);

        return sq;
    }


    public static int square(int toSquare) {
        return toSquare * toSquare;
    }
}