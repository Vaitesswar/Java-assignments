package mycollection;

import java.util.HashMap;
import java.util.Map;

public class TestCollection6 {

    public static void main(String[] args) {
        Map<String, Integer> myMap = new HashMap<>(); // HashMap -> No ordering and no sorting
        myMap.put("Name", null);
        myMap.put("Vai", 4);
        myMap.put("USV", null);
        myMap.put("Baba", 4);
        System.out.println(myMap.get("USV"));
        myMap.put(null,67); // Only 1 null key allowed (unique keys required).
        myMap.put(null,68); // Latest value assigned for null key
    }
}
