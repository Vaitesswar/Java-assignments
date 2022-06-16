package ExceptionHandling;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class TestException2 {
    // user-defined exceptions and built-in exceptions (checked and unchecked exceptions)
    // IOException is the parent exception class of child classes like FileNotFoundException.
    public static void readMyFile() throws IOException { // throw checked exception as of now. It will be handled later.
        FileReader reader = new FileReader("Resources/myfile.txt");
        System.out.println(reader.read());

    }

    public static void main(String[] args) { // Built-in exceptions: Checked (compile time) and unchecked (runtime) exceptions
        try {
            readMyFile();
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
