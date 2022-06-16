package ExceptionHandling;

//POJO: Plain Old Java Object
final class Student{ // Cannot extend classes - Cannot inherit new children. ("final" in class)
    String name;
    final int ID; // Cannot reassign the variable once initialized in an object. ("final" in variable)

    public Student(String name, int ID) {
        this.name = name;
        this.ID = ID;
    }

    public final void myIntro(){ // No overriding ("final" in method)
        System.out.println("Hi, my name is " + this.name + "and my ID is " + this.ID);
    }
}

public class TestException4{

    public static void main(String[] args) {
        Student student = new Student("USV",23);

    }
}
