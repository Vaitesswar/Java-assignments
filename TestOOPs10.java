/// Interface classes gives overall guidelines (gives common rules or gives a contract for future classes).
interface CentralBank{ /// Interface only contains abstract methods unlike abstract classes.
    void getEMI(int rate);
}

interface WorldBank{ /// Interface only contains abstract methods unlike abstract classes.
    void getWorldEMI(int rate);
}

class HSBC implements CentralBank, WorldBank{ /// Can have 2 interfaces unlike abstract class (advantage of interface).

    public void getEMI(int rate){
        System.out.println("Interest rate: " + rate*2);
    }

    public void getWorldEMI(int rate){
        System.out.println("World interest rate: " + rate*3);
    }
}

class OCBC implements CentralBank{

    public void getEMI(int rate){
        System.out.println("Interest rate: " + rate*3);
    }
}

public class TestOOPs10 {
    public static void main(String[] args){
        OCBC ocbc = new OCBC();
        HSBC hsbc = new HSBC();
        ocbc.getEMI(5);
        hsbc.getEMI(5);
    }
}