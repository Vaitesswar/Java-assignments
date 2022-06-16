/// Abstraction - some details can be provided later (We only decide the definition of the method)
/// 1) Abstract class
/// 2) Interface

abstract class MyAbstractClass{ /// Can contain both abstract and concrete methods.

    // methods --> concrete method (both body and definition), abstract method (definition only)
    abstract public void myGreeting(String name); /// Abstract class cannot have a body.

    public void getIntro(String name){
        System.out.println("Hi " + name);
    }

}

class EnglishCommunity extends MyAbstractClass{ /// Cannot have 2 parent classes (disadvantage of abstract class).

    public void myGreeting(String name){ /// Only pending portion was the body.
        System.out.println("Good morning Mr/Mrs " + name);
    }
}

class TamilCommunity extends MyAbstractClass{

    public void myGreeting(String name){ /// Only pending portion was the body.
        System.out.println("Vanakkam Thiru/Thirumathi " + name);
    }
}

public class TestOOPs9{

    public static void main(String[] args){
        EnglishCommunity EnglishCom = new EnglishCommunity();
        TamilCommunity TamilCom = new TamilCommunity();
        EnglishCom.myGreeting("Vaitesswar");
        TamilCom.myGreeting("Vaitesswar");
        EnglishCom.getIntro("Vaitesswar");
        TamilCom.getIntro("Vaitesswar");
    }

}
