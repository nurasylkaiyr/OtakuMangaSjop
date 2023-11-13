package com.example.sdp_project2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelloController {
    DataManager dataManager = DataManager.getInstance();
    ShoppingCart cart = ShoppingCart.getInstance();
    private Product selectedProduct;
    private double totalPrice; // Variable to store the final price

    OrderStatus orderStatus = new OrderStatus();
    OrderStateContext orderStateContext = new OrderStateContext();
    OrderHistory orderHistory = new OrderHistory("order_history.txt");
    Facade facade = new Facade();


    @FXML
    private Button add1;

    @FXML
    private Button add2;

    @FXML
    private Button add3;

    @FXML
    private Button cart_btn;

    @FXML
    private Button catalog_btn;

    @FXML
    private Button confirm_btn;

    @FXML
    private Button history_btn;

    @FXML
    private Button payment_btn;

    @FXML
    private Button status_btn;

    @FXML
    private AnchorPane zone1;

    private void showSuccessModal() {
        // Создание нового модального окна
        Stage modalStage = new Stage();
        modalStage.initModality(Modality.APPLICATION_MODAL);
        modalStage.setTitle("Otaku Manga");

        // Создание содержимого модального окна
        Label label = new Label("Product successfully added to cart");

        StackPane modalLayout = new StackPane();
        modalLayout.getChildren().add(label);

        // Устанавливаем содержимое модального окна и показываем его
        Scene modalScene = new Scene(modalLayout, 250, 150);
        modalStage.setScene(modalScene);
        modalStage.showAndWait();
    }

    @FXML
    private void handleAdd1ButtonAction() {
        selectedProduct = new Product("Chainsaw man Vol.12", 12);
        cart.addProduct(selectedProduct);
        totalPrice = selectedProduct.price;
        dataManager.setSelectedProduct(selectedProduct);
        dataManager.setTotalPrice(totalPrice);
        showSuccessModal();
        dataManager.setData("IN PROGRESSING");
        orderHistory.saveOrder(cart);
    }
    @FXML
    private void handleAdd2ButtonAction() {
        selectedProduct = new Product("My Hero Academia Vol.35", 10);
        cart.addProduct(selectedProduct);
        totalPrice = selectedProduct.price;
        dataManager.setSelectedProduct(selectedProduct);
        dataManager.setTotalPrice(totalPrice);
        showSuccessModal();
        dataManager.setData("IN PROGRESSING");
        orderHistory.saveOrder(cart);
    }
    @FXML
    private void handleAdd3ButtonAction() {
        selectedProduct = new Product("Spy X Family Vol.10", 16);
        cart.addProduct(selectedProduct);
        totalPrice = selectedProduct.price;
        dataManager.setSelectedProduct(selectedProduct);
        dataManager.setTotalPrice(totalPrice);
        showSuccessModal();
        dataManager.setData("IN PROGRESSING");
        orderHistory.saveOrder(cart);
    }

    @FXML
    private void showOrderState() {
        orderStateContext.setOrderStatusObserver(orderStatus);
        double totalPrice = dataManager.getTotalPrice();
        // Создание нового модального окна
        Stage modalStage = new Stage();
        modalStage.initModality(Modality.APPLICATION_MODAL);
        modalStage.setTitle("Otaku Manga");

        // Создание содержимого модального окна
        Label label = new Label(orderStateContext.updateOrderStatus(dataManager.getData()));
        StackPane modalLayout = new StackPane();
        modalLayout.getChildren().add(label);

        // Устанавливаем содержимое модального окна и показываем его
        Scene modalScene = new Scene(modalLayout, 250, 150);
        modalStage.setScene(modalScene);
        modalStage.showAndWait();
    }

    @FXML
    private void navigateToCatalog() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
            Parent secondPageParent = loader.load();
            Scene secondPageScene = new Scene(secondPageParent);
            Stage primaryStage = (Stage) cart_btn.getScene().getWindow(); // Получаем текущий Stage
            primaryStage.setScene(secondPageScene); // Устанавливаем новую сцену
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace(); // Обработка ошибок загрузки FXML файла
        }
    }
    /*=========================CART==============================*/
    @FXML
    private Label selectedPrdouctTitle;
    @FXML
    private Button add_disc;

    @FXML
    private Button add_expdel;

    @FXML
    private Button add_pack;


    @FXML
    private void navigateToCart() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("cart.fxml"));
            Parent secondPageParent = loader.load();
            Scene secondPageScene = new Scene(secondPageParent);
            Stage primaryStage = (Stage) cart_btn.getScene().getWindow(); // Получаем текущий Stage
            primaryStage.setScene(secondPageScene); // Устанавливаем новую сцену
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace(); // Обработка ошибок загрузки FXML файла
        }
    }
    @FXML
    private void addPackaging() {
        List<Product> cartProducts = cart.getProducts();
        for (Product product : cartProducts){
            selectedProduct = dataManager.getSelectedProduct();
            selectedProduct = new PackagingDecorator(selectedProduct);
            dataManager.setSelectedProduct(selectedProduct);
            totalPrice = dataManager.getTotalPrice() + 5;
            dataManager.setTotalPrice(totalPrice);
            orderHistory.saveOrder(cart);
        }
        // Создание нового модального окна
        Stage modalStage = new Stage();
        modalStage.initModality(Modality.APPLICATION_MODAL);
        modalStage.setTitle("Otaku Manga");

        // Создание содержимого модального окна
        Label label = new Label("Product packaging successfully purchased");
        StackPane modalLayout = new StackPane();
        modalLayout.getChildren().add(label);

        // Устанавливаем содержимое модального окна и показываем его
        Scene modalScene = new Scene(modalLayout, 250, 150);
        modalStage.setScene(modalScene);
        modalStage.showAndWait();
    }
    @FXML
    private void addExpDel() {
        List<Product> cartProducts = cart.getProducts();
        for (Product product : cartProducts){
            selectedProduct = dataManager.getSelectedProduct();
            selectedProduct = new ExpressDeliveryDecorator(selectedProduct);
            dataManager.setSelectedProduct(selectedProduct);
            totalPrice = dataManager.getTotalPrice() + 10;
            dataManager.setTotalPrice(totalPrice);
            orderHistory.saveOrder(cart);
        }
        // Создание нового модального окна
        Stage modalStage = new Stage();
        modalStage.initModality(Modality.APPLICATION_MODAL);
        modalStage.setTitle("Otaku Manga");

        // Создание содержимого модального окна
        Label label = new Label("Express delivery successfully purchased");
        StackPane modalLayout = new StackPane();
        modalLayout.getChildren().add(label);

        // Устанавливаем содержимое модального окна и показываем его
        Scene modalScene = new Scene(modalLayout, 250, 150);
        modalStage.setScene(modalScene);
        modalStage.showAndWait();
    }
    @FXML
    private void addDiscount() {
        List<Product> cartProducts = cart.getProducts();
        for (Product product : cartProducts){
            selectedProduct = dataManager.getSelectedProduct();
            selectedProduct = new DiscountDecorator(selectedProduct);
            dataManager.setSelectedProduct(selectedProduct);
            totalPrice = dataManager.getTotalPrice() * 0.9;
            dataManager.setTotalPrice(totalPrice);
            orderHistory.saveOrder(cart);
        }
        // Создание нового модального окна
        Stage modalStage = new Stage();
        modalStage.initModality(Modality.APPLICATION_MODAL);
        modalStage.setTitle("Otaku Manga");

        // Создание содержимого модального окна
        Label label = new Label("Your 10% discount has been successfully activated");
        StackPane modalLayout = new StackPane();
        modalLayout.getChildren().add(label);

        // Устанавливаем содержимое модального окна и показываем его
        Scene modalScene = new Scene(modalLayout, 250, 150);
        modalStage.setScene(modalScene);
        modalStage.showAndWait();
    }

    /*=============================PAYMENT================================*/
    @FXML
    private void navigateToPayment() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("payment.fxml"));
            Parent secondPageParent = loader.load();
            Scene secondPageScene = new Scene(secondPageParent);
            Stage primaryStage = (Stage) cart_btn.getScene().getWindow(); // Получаем текущий Stage
            primaryStage.setScene(secondPageScene); // Устанавливаем новую сцену
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace(); // Обработка ошибок загрузки FXML файла
        }
    }

    @FXML
    private Button card_pay;

    @FXML
    private Button paypal_pay;

    @FXML
    private Button webmoney_pay;

    private void showSuccessPayment() {
        totalPrice = dataManager.getTotalPrice();
        PaymentStrategy paymentStrategy = dataManager.getPaymentStrategy();
        // Создание нового модального окна
        Stage modalStage = new Stage();
        modalStage.initModality(Modality.APPLICATION_MODAL);
        modalStage.setTitle("Otaku Manga");

        // Создание содержимого модального окна
        Label label = new Label(paymentStrategy.pay(totalPrice) + "Thank you for your purchase!");
        StackPane modalLayout = new StackPane();
        modalLayout.getChildren().add(label);

        // Устанавливаем содержимое модального окна и показываем его
        Scene modalScene = new Scene(modalLayout, 350, 150);
        modalStage.setScene(modalScene);
        modalStage.showAndWait();
        dataManager.setData("SENT");
    }
    @FXML
    private void creditcardPayment() {
        PaymentStrategy paymentStrategy = new CreditCardPayment();
        dataManager.setPaymentStrategy(paymentStrategy);
        showSuccessPayment();
        orderHistory.saveOrder(cart);
    }
    @FXML
    private void paypalPayment() {
        PaymentStrategy paymentStrategy = new PayPalPayment();
        dataManager.setPaymentStrategy(paymentStrategy);
        showSuccessPayment();
        orderHistory.saveOrder(cart);
    }

    @FXML
    private void webmoneyPayment() {
        PaymentStrategy paymentStrategy = new WebMoneyPayment();
        dataManager.setPaymentStrategy(paymentStrategy);
        showSuccessPayment();
        orderHistory.saveOrder(cart);
    }

    /*====================CONFIRM ORDER========================*/
    @FXML
    private void confirmOrder() {
        dataManager.setData("DELIVERED");
        // Создание нового модального окна
        Stage modalStage = new Stage();
        modalStage.initModality(Modality.APPLICATION_MODAL);
        modalStage.setTitle("Otaku Manga");

        // Создание содержимого модального окна
        Label label = new Label("You have confirmed the order has been received. Congratulations on your purchase!");
        StackPane modalLayout = new StackPane();
        modalLayout.getChildren().add(label);

        // Устанавливаем содержимое модального окна и показываем его
        Scene modalScene = new Scene(modalLayout, 350, 150);
        modalStage.setScene(modalScene);
        modalStage.showAndWait();
    }

    /*==================ORDER HISTORY===================*/
    @FXML
    private void showOrderHistory() {
        String output = null;
        totalPrice = dataManager.getTotalPrice();
        String lastOrder = orderHistory.getLastOrder();
//        if (lastOrder != null) {
//            for (Product product : lastOrder.getProducts()) {
//                output ="Last Order:" + product.name + " - $" + totalPrice;
//            }
//        } else {
//            output = "No order history available.";
//        }
        // Создание нового модального окна
        Stage modalStage = new Stage();
        modalStage.initModality(Modality.APPLICATION_MODAL);
        modalStage.setTitle("Otaku Manga");

        // Создание содержимого модального окна
        Label label = new Label("Last order: " + lastOrder);
        StackPane modalLayout = new StackPane();
        modalLayout.getChildren().add(label);

        // Устанавливаем содержимое модального окна и показываем его
        Scene modalScene = new Scene(modalLayout, 350, 150);
        modalStage.setScene(modalScene);
        modalStage.showAndWait();
    }
}


