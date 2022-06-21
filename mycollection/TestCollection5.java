package mycollection;

import java.util.Hashtable;
import java.util.Map;

public class TestCollection5 {
    public static void main(String[] args) {
        Map<String, Integer> myMap = new Hashtable<>(); // Thread safety (No more than 2 threads can access the same method together - Synchronous)
        myMap.put("Name", 2);
        myMap.put("Vai", 4);
        //myMap.put(null, null); // No null key & no null value.
        System.out.println(myMap.get("Vai"));
    }
}
