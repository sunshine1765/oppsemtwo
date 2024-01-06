package Classes;

public class promotionalClient extends Actor {

    static String namePromotional; // Название акции
    static int id; // id клиента акции
    static int numberClient; // Количество участников в акции

    public promotionalClient(String name,String namePromotional, int id, int numberClient) {
        super(name);
        this.namePromotional = namePromotional; // Название акции
        this.id = id; // id клиента
        this.numberClient = numberClient; // кол-во участников
    }

    @Override
    public String getName() {
        return super.name;
    }

    @Override
    public void setName(String name) {
        super.name = name;
    }

    public static void setId(int id) {
        promotionalClient.id = id;
    }

    public static int getId() {
        return id;
    }

    public static void setNumberClient(int numberClient) {
        promotionalClient.numberClient = numberClient;
    }

    public static int getNumberClient() {
        return numberClient;
    }


    @Override
    public boolean isTakeOrder() {
        return false;
    }

    @Override
    public boolean isMakeOrder() {
        return false;
    }

    @Override
    public void setTakeOrder(boolean val) {

    }

    @Override
    public void setMakeOrder(boolean val) {

    }

    @Override
    public Actor geActor() {
        return this;
    }
}
