package mycollection;

import java.util.Comparator;
import java.util.Objects;
import java.util.TreeSet; // sorted set (order becomes invalid)

class Student1 implements Comparable<Student1>{

    private String name;
    private int ID;

    public Student1(String name, int ID) {
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
        Student1 student1 = (Student1) o;
        return ID == student1.ID && Objects.equals(name, student1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, ID);
    }

    @Override
    public int compareTo(Student1 o) {
        if (this.getID() > o.getID()){
            return 1; // Positive (After)
        } else if (this.getID() < o.getID()){
            return -1; // Negative (Before)
        } else {
            return 0; // 0 (Equals)
        }
    }
}

class CompareID implements Comparator<Student1> {

    @Override
    public int compare(Student1 o1, Student1 o2) {
        if (o1.getID() > o2.getID()){
            return 1; // Positive (After)
        } else if (o1.getID() < o2.getID()){
            return -1; // Negative (Before)
        } else {
            return 0; // 0 (Equals)
        }
    }
}

public class TestCollection4 {
    public static void main(String[] args){
        TreeSet<Student1> treeSet = new TreeSet<Student1>(); // Comparable
        // TreeSet<Student1> treeSet = new TreeSet<Student1>(new CompareID()); // Comparator
        Student1 student1 = new Student1("Peter",54);
        Student1 student2 = new Student1("John", 3);
        Student1 student3 = new Student1("Peter",35);
        Student1 student4 = new Student1("Peace",47);
        treeSet.add(student1);
        treeSet.add(student2);
        treeSet.add(student3);
        treeSet.add(student4);
        treeSet.add(student4);
        System.out.println(treeSet);
    }
}
