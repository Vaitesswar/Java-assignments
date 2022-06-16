package mycollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// ArrayList -> Singly linked powerful array with no predefined size (Singly linked - Fast iteration but not good for adding & removing elements)

public class TestCollection {
    public static void main(String[] args){
        // Creating list
        List<String> list = new ArrayList<String>(); // Way 1
        ArrayList<String> list1 = new ArrayList<String>(); // Way 2

        // Adding elements
        list.add("John");
        list.add("Henry");
        list.add("Andy");
        System.out.println(list);
        Collections.sort(list); // sorting
        System.out.println(list);

        // Iteration
        for(String name:list){
            System.out.println(name);
        }

        Iterator<String> itr = list.iterator();

        while (itr.hasNext()){
            System.out.println(itr.next());
        }

        // Removing elements
        list.remove("Andy");


    }

}
