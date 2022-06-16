package mycollection;

import java.util.HashSet;

public class TestCollection2 {
    public static void main(String[] args){
        HashSet<String> hashSet = new HashSet<String>(); // unordered (no order of insertion) and unsorted set
        hashSet.add("Rajesh");
        hashSet.add("Tom");
        hashSet.add("Andy");
        hashSet.add("Jerry");
        hashSet.add("Jerry");

        System.out.println(hashSet);
    }
}
