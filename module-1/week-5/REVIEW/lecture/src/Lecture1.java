import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Lecture1 {
    public static void main(String[] args) {

        System.out.println("####################");
        System.out.println("        MAPS");
        System.out.println("####################");
        System.out.println();
        // 1)  Declaring and initializing a Map
        Map<String, String> nameToZip = new HashMap<>();


        // 2)  Adding Map entries
        nameToZip.put("Mary Jones", "60100");
        nameToZip.put("Bob Smith", "60101");
        nameToZip.put("Jen Kraus", "60102");
        nameToZip.put("Bob Rich", "60100");


        // 3)  Retrieve values from a Map
        System.out.println("Retrieve values from the Map");
        System.out.println("Bob lives at zipcode: " + nameToZip.get("Bob Rich"));
        System.out.println("Jen lives at zipcode: " + nameToZip.get("Jen Kraus"));


        // 4)  Retrieve just the Keys (Key Set)
        System.out.println("\nLet's get just the Keys (Key Set):");
        Set<String> nameToZipKeys = nameToZip.keySet();
        for (String key : nameToZipKeys) {
            System.out.println("This is the key for: " + key);
        }


        // 5)  Leverage the access to the Key Set, to extract the keys
        //     and use the keys to extract Values
        System.out.println("\nLeverage the access to the Key Set to " +
                            " extract the Keys and use them to extract the Values");
       for (String key : nameToZipKeys) {
           System.out.println(key + " lives in zipcode: " + nameToZip.get(key));
       }



        // 6)  Updating Key Values
        System.out.println("\nUpdating Key Values");
        nameToZip.put("Bob Smith", "99999");
        for (String key : nameToZipKeys) {
            System.out.println(key + " lives in zipcode: " + nameToZip.get(key));
        }



        // 7)  Checking for Key existence
        System.out.println("\nChecking for Key existence");
        System.out.println("Does Jen K have an entry into the Map? "
                            + nameToZip.containsKey("Jen Kraus"));
        System.out.println("Does George Foreman have an entry into the Map? " +
                            nameToZip.containsKey("George Foreman"));

        // 8)  Removing a Entry");
        System.out.println("\nRemoving an Entry");
        System.out.println("I have removed: " + nameToZip.remove("Bob Jones") +
                            " from the Map.");
        System.out.println("I have removed: " + nameToZip.remove("Bob Smith") +
                " from the Map.");
        for (String key : nameToZipKeys) {
            System.out.println(key + " lives in zipcode: " + nameToZip.get(key));
        }

        // 9)  Scanner prompting for user to input keyToRemove is replaced by
        // hard code below to save lecture time
        System.out.println("\nRemove Bob Smith");
        String keyToRemove = new String("Bob Rich");  // String keyToRemove = "Bob Smith";
        String valRemoved = nameToZip.remove(keyToRemove);
        System.out.println("I have removed zipcode: " + valRemoved +
                            " associated with " + keyToRemove);
        String keyToRemoveJen = new String("Jen Kraus");  // String keyToRemove = "Bob Smith";
        String valRemovedJen = nameToZip.remove(keyToRemoveJen);
        System.out.println("I have removed zipcode: " + valRemovedJen +
                " associated with " + keyToRemoveJen);
        for (String key : nameToZipKeys) {
            System.out.println(key + " lives in zipcode: " + nameToZip.get(key));
        }
        // 10)  Restore Key that was removed, Scanner prompting for user to select
        // true or false (yes or no) is replaced by hard code to save lecture time
        System.out.println("\nRestore Bob Rich");
        boolean areYouSure = false;
        if (!areYouSure) {
            System.out.println("Restoring " + keyToRemove + " : " +
                                valRemoved);
            nameToZip.put(keyToRemove, valRemoved);
            nameToZip.put("Jen Kraus", "60102");
        }
        for (String key : nameToZipKeys) {
            System.out.println(key + " lives in zipcode: " + nameToZip.get(key));
        }


        // 11)  Iterate through entire Map entries
        System.out.println("\nLet's iterate over the Map entries");
        for (Map.Entry<String, String> nameZipEntry : nameToZip.entrySet()) {
            System.out.println(nameZipEntry);
        }

    }
}