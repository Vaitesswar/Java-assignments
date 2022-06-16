class Student1 {

    private int marks; // default is not public. If no access modifier is given, it means it is "default" (no key word). The 4th access modifier.
    private String name; // Accessible only within class (Cannot change attributes for an object)
    private int rollNo;

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }


    /// Constructor overloading (Many constructors (initialization) for the same class)
    // -> Difference in number of parameters and type of objects.
    Student1 (int marks, String name, int rollNo){
        this.marks = marks;
        this.name = name;
        this.rollNo = rollNo;
    }

    Student1 (int marks, String name){
        this.marks = marks;
        this.name = name;
    }

    Student1 () {

    }

    public void getIntro(){
        System.out.println("My name is " + this.name + ". My roll number is " + this.rollNo + ". My marks is " + this.marks + ".");
    }

}

public class TestOOPs5 {
    public static void main(String[] args){
        /// Multiple ways to create objects for same class
        Student1 student = new Student1(101,"USV",3);
        Student1 student1 = new Student1(101,"USV");
        Student1 student2 = new Student1();
        //student.rollNo = 25; // Dangerous to allow attributes of an object to be changed.
        student.getIntro();
        student.setMarks(27);
        student.getIntro();
        System.out.println(student.getName());
    }
}
