import java.util.Scanner;

class Student {

    private int marks; /// Private access
    private String name;

    public int getMarks() { /// Getter function
        return marks;
    }

    public String getName() {
        return name;
    }

    Student (int marks, String name){
        this.marks = marks;
        this.name = name;
    }

}

class Grader {

    Grader(){}

    public void Grade(Student person){ // Passing in the object rather than a single data (OOP style).
        if (person.getMarks() >= 90 && person.getMarks() <= 100) {
            System.out.println("Hi " + person.getName() + ", your marks is " + person.getName() + ". Hence, your grade is A.");
        } else if (person.getMarks() >= 80 && person.getMarks() < 90) {
            System.out.println("Hi " + person.getName() + ", your marks is " + person.getMarks() + ". Hence, your grade is B.");
        } else if (person.getMarks() >= 70 && person.getMarks() < 80) {
            System.out.println("Hi " + person.getName() + ", your marks is " + person.getMarks() + ". Hence, your grade is C.");
        } else {
            System.out.println("Hi " + person.getName() + ", your marks is " + person.getMarks() + ". Hence, your grade is Fail.");
        }
    }
}

public class StudentGrader {

    public static void main(String[] args) {

        Student student = new Student(95, "John"); // For OOP, data has to be stored via a class. Not simply using data.
        Student student_1 = new Student(82, "Bob");
        Student student_2 = new Student(73, "Mary");
        Student student_3 = new Student(55, "Steve");
        Grader grader = new Grader();
        grader.Grade(student);
        grader.Grade(student_1);
        grader.Grade(student_2);
        grader.Grade(student_3);
    }



}
