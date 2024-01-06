package Interfaces;

public interface iReturnOrder {
    static void initiateReturn(int orderId) { // метод иницилизации возврата товара

    }

    void cancelReturn(int orderId); // отказ от товара
    void getReturnStatus(int orderId); // статус возврата
    void notifyReturnUpdate(int orderId); // Возврат аптейты
}
