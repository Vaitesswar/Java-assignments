package mycollection;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class TestCollection8 {

    public static void main(String[] args) {
        Map<Integer, Integer> myMap = new TreeMap<>(); // LinkedHashMap -> Sorted map (order of insertion becomes irrelevant).
        myMap.put(1, null);
        myMap.put(5, 4);
        myMap.put(2, null);
        myMap.put(4, 4);
        //System.out.println(myMap.get("USV"));
        myMap.put(3,67); // Only 1 null key allowed (unique keys required).
        //myMap.put(null,68); // Latest value assigned for null key

        for(Integer name: myMap.keySet()){
            System.out.println(name);
            //System.out.println(myMap.get(name));
        }
    }
}
