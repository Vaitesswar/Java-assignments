
// Everything have to be defined inside a class. No variables cannot be created outside a class.
class MyClass {

    public int x = 10; // private, protected and public
    public float y;
    public boolean z;
    public String a;
    public int getValueOfX() {
        return x;

    }
}

class MyClass2 {

    public static int x = 10; // private, protected and public
    public static int getValueOfX() {
        return x;

    }
}

public class TestStatic {
    /*
    public static int x = 10; // private, protected and public

    public int getValueOfX(){
        return x;
    }
    */
    public static void main(String[] args) {
        MyClass obj = new MyClass(); // creating objects
        System.out.println(obj.x);
        System.out.println(obj.y); // Java automatically allocates a value for an unassigned variable.
        System.out.println(obj.z);
        System.out.println(obj.a);
        System.out.println(obj.getValueOfX());
        System.out.println(MyClass2.x); // When the variable/function is static, you do not need to create an object to access the variable/function.
        System.out.println(MyClass2.getValueOfX()); // static
    }

}