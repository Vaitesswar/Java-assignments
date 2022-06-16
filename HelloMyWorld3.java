public class HelloMyWorld3 {

    // creating function
    public static void addition(int a, int b){
        int result = a + b;
        System.out.println(result);
    }

    public static int AreaSquare(int side){ // must declare both input and output data types when defining function
        int result = side * side;
        return result;
    }

    public static void main(String[] args) {
        addition(5, 10);
        System.out.println(AreaSquare(5)*5);
    }
}