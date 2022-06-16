package ExceptionHandling;

public class TestException {

    public static void main(String[] args){
        int a = 10;
        int b = 2;
        int c = 0;
        try{
            c = a/b;
        } catch (ArithmeticException e){ // e is an object of ArithmeticException class.
            System.out.println(e.getMessage());
        }
    System.out.println(c);
    }

}
