package Interfaces;

import java.util.List;

import Classes.Actor;

public interface iMarcketBehaviour {
    public void acceptToMarket(iActorBehaviour actor);
    public void releseFromMarket(List<Actor> actors);
    public void update();

    String initiateReturn();

    String initiateReturn(int orderId);

    String cancelReturn(int orderId);

    String getReturnStatus(int orderId);

    String notifyReturnUpdate(int orderId);
}
