package mypackage;

public class TestPackageInside {

    public static void main(String[] args) {
        myPackage myPac = new myPackage();
        TestClass obj = new TestClass();
        myPac.printMe();
        obj.printMe(); ///
    }
}
