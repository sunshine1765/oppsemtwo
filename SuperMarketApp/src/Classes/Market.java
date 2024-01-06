package Classes;

import java.util.ArrayList;
import java.util.List;

import Interfaces.iActorBehaviour;
import Interfaces.iMarcketBehaviour;
import Interfaces.iQueueBehaviour;


public class Market implements iMarcketBehaviour, iQueueBehaviour {

    private List<iActorBehaviour> queue;

    public Market() {
        this.queue = new ArrayList<>();
    }

    @Override
    public void acceptToMarket(iActorBehaviour actor) {
        if (actor.geActor() != null) {
            System.out.println(actor.geActor().getName() + " клиент пришел в магазин ");
            takeInQueue(actor);
        } else {
            System.out.println("Ошибка: объект Actor равен null.");
        }
    }

    @Override
    public void takeInQueue(iActorBehaviour actor) {
        this.queue.add(actor);
        System.out.println(actor.geActor().getName() + " клиент добавлен в очередь ");
    }

    @Override
    public void releseFromMarket(List<Actor> actors) {
        for (Actor actor : actors) {
            System.out.println(actor.getName() + " клиент ушел из магазина ");
            queue.remove(actor);
        }
    }

    @Override
    public void update() {
        takeOrder();
        giveOrder();
        releaseFromQueue();
    }

    @Override
    public void giveOrder() {
        for (iActorBehaviour actor : queue) {
            if (actor.isMakeOrder()) {
                actor.setTakeOrder(true);
                System.out.println(actor.geActor().getName() + " получил свой заказ.");

                // Вызываем возврат товара после получения
                String returnMessage = initiateReturn();
                System.out.println(actor.geActor().getName() + " " + returnMessage);
            }
        }
    }

    public String initiateReturn() {
        return "инициировал(-а) возврат для заказа";
    }

    @Override
    public void releaseFromQueue() {
        List<Actor> releaseActors = new ArrayList<>();
        for (iActorBehaviour actor : queue) {
            if (actor.isTakeOrder()) {
                releaseActors.add(actor.geActor());
                System.out.println(actor.geActor().getName() + " клиент ушел из очереди ");
            }
        }
        releseFromMarket(releaseActors);
    }

    @Override
    public void takeOrder() {
        for (iActorBehaviour actor : queue) {
            if (!actor.isMakeOrder()) {
                actor.setMakeOrder(true);
                System.out.println(actor.geActor().getName() + " клиент сделал заказ ");
            }
        }
    }
    @Override
    public String initiateReturn(int orderId) {
        // Логика инициирования возврата
        return "инициировал(-а) возврат для заказа" + orderId;
    }

    @Override
    public String cancelReturn(int orderId) {
        return null;
    }

    @Override
    public String getReturnStatus(int orderId) {
        return null;
    }

    @Override
    public String notifyReturnUpdate(int orderId) {
        return null;
    }
}