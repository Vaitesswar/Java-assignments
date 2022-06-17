package mycollection;

import java.util.Hashtable;
import java.util.Map;

public class TestCollection5 {
    public static void main(String[] args){
        Map<String,Integer> myMap = new Hashtable<>();
        myMap.put("Name",2);
        myMap.put("Vai",4);
        System.out.println(myMap.get("Vai"));
    }
}
