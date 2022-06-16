class Calculator1 {

    private int x; /// variable x (attribute of object)
    private int y;

    /// Constructor overloading (Many constructors (initialization) for the same class)
    public Calculator1(){}

    public Calculator1(int x, int y) { /// value to set for variable x.
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    /// Method overloading (Same function name with different number of inputs)
    public int add(int a, int b){
        int sum = a + b;
        return sum;
    }

    public int add(int a, int b, int c){
        int sum = a + b + c;
        return sum;
    }
}

public class TestOOPs6 {
    public static void main(String[] args){
        Calculator1 calculator = new Calculator1();
        System.out.println(calculator.add(1,2));
        System.out.println(calculator.add(1,2,3));
    }
}
