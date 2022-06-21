package java8features;

import java.util.*;

//Java 8 Features
//1) Lambda Expression --> implementation of functional interface (anonymous function)
//2) Functional interface --> interface with exactly one method to implement (Comparator/Comparable interface)
//3) Stream API

class Student2{

    private String name;
    private int ID;

    public Student2(String name, int ID) {
        this.name = name;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", ID=" + ID +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student2 student2 = (Student2) o;
        return ID == student2.ID && Objects.equals(name, student2.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, ID);
    }

}

public class LambdaExpression {
    public static void main(String[] args){
        ArrayList<Student2> arrayList = new ArrayList<Student2>();
        Student2 student1 = new Student2 ("Peter",54);
        Student2  student2 = new Student2 ("John", 3);
        Student2  student3 = new Student2 ("Peter",35);
        Student2  student4 = new Student2 ("Peace",47);
        arrayList.add(student1);
        arrayList.add(student2);
        arrayList.add(student3);
        arrayList.add(student4);
        arrayList.add(student4);
        // Lambda expression for sorting
        Collections.sort(arrayList, (Student2 o1, Student2 o2) -> {return Integer.compare(o1.getID(),o2.getID());});
        System.out.println(arrayList);
    }
}
