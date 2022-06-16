package ExceptionHandling;

public class TestException3 {
    public static void divide(int a, int b){ // Static method cannot call non-static method but vice versa works.
        try{
            int c = a/b;
            System.out.println(c);
        } catch (ArithmeticException e){ // e is an object of ArithmeticException class.
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) { // Without static, the server cannot call this method without instantiating a class.
        int a = 10;
        int b = 2;
        divide(a, b);
        try {
            int d = a / b;
            System.out.println(d);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (
                Exception g) { // Exception class (generic class) should be the last of exceptions. Otherwise, it will hide all other exceptions.
            System.out.println(g.getMessage());
        } finally { // used for resource de-allocation
            System.out.println("Always gets executed."); // Always gets executed even with or without exceptions.
        }
    }
}