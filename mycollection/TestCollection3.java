package mycollection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class TestCollection3 {
    public static void main(String[] args){
        LinkedHashSet<String> hashSet = new LinkedHashSet<String>(); // ordered (order of insertion) and unsorted set
        hashSet.add("Rajesh");
        hashSet.add("Tom");
        hashSet.add("Andy");
        hashSet.add("Jerry");
        hashSet.add("Jerry");
        System.out.println(hashSet);
    }
}
