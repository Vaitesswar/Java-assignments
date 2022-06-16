package mypackage;

/// Method types
///private --> Only within class (Cannot inherit)
///default --> Only within package (Cannot inherit)
///public --> Inside, outside package and file (Each code can only have 1 public class).
///protected --> For outside package, need to inherit

class myPackage{

     public void printMe(){
        System.out.println("Hi !");
    }
}

public class TestClass {

    protected void printMe(){
        System.out.println("Hi !");
    }

    public static void main(String[] args){
        myPackage myPac = new myPackage();
    }
}
