import mypackage.TestClass;

public class TestPackageOutside extends TestClass{

    public static void main(String[] args){
        TestClass testPackage = new TestClass();
        TestPackageOutside testPackageOutside = new TestPackageOutside();
        ///testPackage.printMe(); /// Protected method, hence not available outside class
        testPackageOutside.printMe(); /// Once extended, can access the protected method.
    }
}
