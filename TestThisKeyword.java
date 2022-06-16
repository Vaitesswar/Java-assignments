class MyClass3 {

    int x = 10;
    static int x1 = 10; // x1 is not confined to this class
    int getValueOfX() {
        return this.x; // return variable 'x' from this class (variable 'x' is confined within this class)
    }
    static int getValueOfX1() {
        return x1; // static function cannot access non-static variable but vice versa works
    }
}

public class TestThisKeyword {
    public static void main(String[] args) {
        MyClass3 obj = new MyClass3(); // creating objects
        obj.x = 50; // changing an attribute of x
        int x = 20;
        System.out.println(obj.x);
        System.out.println(x);
        System.out.println(MyClass3.x1);
    }

}