import Classes.*;
import Interfaces.iActorBehaviour;

public class App {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");

        Market magnit = new Market();

        Actor client1 = new OrdinaryClient("boris");
        Actor client2 = new OrdinaryClient("masha");
        Actor client3 = new SpecialClient("prezident", 1);
        Actor client4 = new promotionalClient("Oleg", "Action2", 11, 10);

       // Actor client4 = new TaxInspector();

        magnit.acceptToMarket(client1);
        magnit.acceptToMarket(client2);
        magnit.acceptToMarket(client3);
        magnit.acceptToMarket(client4);
        magnit.update();
    }
}
