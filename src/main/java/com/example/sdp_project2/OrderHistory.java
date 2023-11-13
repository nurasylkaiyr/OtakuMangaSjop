package com.example.sdp_project2;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class OrderHistory {
    private ShoppingCartMemento lastOrder;
    private SaveOrderToTxtFile saveOrderCommand;
    String filename = "order_history.txt";

    public OrderHistory(String filename) {
        this.saveOrderCommand = new SaveOrderToTxtFile(filename);
    }


    public void saveOrder(ShoppingCart cart) {
        lastOrder = new ShoppingCartMemento(cart.getProducts());
        // Save the order to a text file using the command
        saveOrderCommand.execute(lastOrder.getProducts());
    }

    public String getLastOrder() {
        StringBuilder content = new StringBuilder();
        String line = null;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            while ((line = br.readLine()) != null) {
                // Читаем строку из файла и выводим ее
                content.append(line);
            }
        } catch (IOException e) {
            // Обрабатываем возможные исключения, например, если файл не найден
            e.printStackTrace();
        }
        return content.toString();
    }
}
