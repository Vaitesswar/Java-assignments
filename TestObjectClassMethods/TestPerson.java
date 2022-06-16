package TestObjectClassMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

class Student{

    private String name;
    private int ID;

    public Student(String name, int ID) {
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
        Student student = (Student) o;
        return ID == student.ID && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        char character = name.charAt(0); // ASCII character encoding based on first letter.
        return character + ID;
    }

}

public class TestPerson {
    public static void main(String[] args) {
        Student student1 = new Student("Peter",108);
        Student student2 = new Student("John", 3);
        Student student3 = new Student("Peter",108);
        Student student4 = new Student("Peace",108);
        System.out.println(student1);
        System.out.println(student1.hashCode());
        System.out.println(student2);
        System.out.println(student2.hashCode());
        System.out.println(student3);
        System.out.println(student3.hashCode());
        System.out.println(student4);
        System.out.println(student4.hashCode());
        // Students 1 and 3 have same hashcode (Same starting letter) and their properties are same.
        System.out.println(student1.equals(student3));
        // Students 1 and 4 have same hashcode (Same starting letter) but their properties are different.
        System.out.println(student1.equals(student4));

        // ------- Searching a student object (comparing with/without hashing)----------

        // Storing student objects
        String[] names = {"Tallon",
                "Zariah",
                "Harlyn",
                "Alucard",
                "Farren" ,
                "Jaelyn" ,
                "Rowan" ,
                "Yehuda" ,
                "Anwen" ,
                "Gage" ,
                "Dion" ,
                "Torryn" ,
                "Enoch" ,
                "Britta" ,
                "Sveah" ,
                "Rhea" ,
                "Thaddeus" ,
                "Neva" ,
                "Bronwy" ,
                "Makenna" ,
                "Imre" ,
                "Greer" ,
                "Elora" ,
                "Josiah" ,
                "Caspian" ,
                "Roderick" ,
                "Ainsley" ,
                "Kyan" ,
                "Embry" ,
                "Ina" ,
                "Augustin" ,
                "Bodhi" ,
                "Ulani" ,
                "Corbin" ,
                "Kaia" ,
                "Gracen" ,
                "Malachi" ,
                "Thea" ,
                "Delaney" ,
                "Yael" ,
                "Elora" ,
                "Hartley" ,
                "Lachla" ,
                "Oriana" ,
                "Vaughn" ,
                "Zuri" ,
                "Royce" ,
                "Kimya" ,
                "Hensle" ,
                "Damiah"};
        Random rand = new Random();
        ArrayList <Student> Students = new ArrayList<>();
        int[] IDs = new int[names.length];
        for (int i = 0; i < names.length; i += 1){
            int ID = rand.nextInt(100) + 1;
            IDs[i] = ID;
            Student student = new Student(names[i],ID);
            Students.add(student);
        }

        // Random student to search
        int searchInd = rand.nextInt(names.length);
        String searchName = names[searchInd];
        int searchID = IDs[searchInd];
        Student searchStudent = new Student(searchName, searchID);

        // Searching for random student in list of objects (without hashing)
        long startTime = System.nanoTime();
        for (Student student:Students){
            if (student.equals(searchStudent)){
                //System.out.println(student);
                //System.out.println(searchStudent);
                break;
            }
        }
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("Time elapsed (without hashing): " + estimatedTime + " ns");

        // Searching for random student in list of objects (using hashing)
        long startTime1 = System.nanoTime();
        int searchHash = searchStudent.hashCode();
        for (Student student:Students){
            if (student.hashCode() == searchHash){
                //System.out.println(student);
                //System.out.println(searchStudent);
                break;
            }
        }
        long estimatedTime1 = System.nanoTime() - startTime1;
        System.out.println("Time elapsed (with hashing): " + estimatedTime1 + " ns");
    }
}
