package com.example.sdp_project2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        OrderHistory orderHistory = new OrderHistory("order_history.txt");
        ShoppingCart cart = ShoppingCart.getInstance();
        OrderStatus orderStatus = new OrderStatus();
        OrderStateContext orderStateContext = new OrderStateContext();
        orderStateContext.setOrderStatusObserver(orderStatus);
        String ordstatus = "IN PROCESSING";
        Scanner scanner = new Scanner(System.in);
        List<ProductDecorator> decoratedProducts = new ArrayList<>();
        System.out.println("<-----Welcome to the Otaku Manga Shop!----->");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Product catalog");
            System.out.println("2. Basket");
            System.out.println("3. Payment");
            System.out.println("4. Order Status");
            System.out.println("5. Confirm the Order");
            System.out.println("6. Order History");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    // Product catalog
                    System.out.println("\nCategory:");
                    List<Product> products = new ArrayList<>();
                    products.add(new Product("Chainsaw man Vol.12", 12));
                    products.add(new Product("My Hero Academia Vol.35", 10));
                    products.add(new Product("Spy X Family Vol.10", 16));

                    System.out.println("Available products:");
                    for (int i = 0; i < products.size(); i++) {
                        System.out.println((i + 1) + ". " + products.get(i).name + " - $" + products.get(i).price);
                    }

                    System.out.print("Enter the product number to add to the cart: ");
                    int productNumber = scanner.nextInt();
                    Product selectedProduct = products.get(productNumber - 1);

                    // Add product to cart using Singleton pattern
                    cart.addProduct(selectedProduct);
                    orderHistory.saveOrder(cart);
                    System.out.println(selectedProduct.name + " added to the cart.");
                    break;
                case 2:
                    // Basket
                    System.out.println("\nCart:");
                    List<Product> cartProducts = cart.getProducts();
                    for (Product product : cartProducts) {
                        System.out.println(product.name + " - $" + product.price);
                        System.out.println("1. Add Packaging - $5");
                        System.out.println("2. Add Express Delivery - $10");
                        System.out.println("3. Apply 10% Discount");

                        System.out.print("Enter your choice for " + product.name + ": ");
                        int option = scanner.nextInt();

                        switch (option) {
                            case 1:
                                decoratedProducts.add(new PackagingDecorator(product));
                                break;
                            case 2:
                                decoratedProducts.add(new ExpressDeliveryDecorator(product));
                                break;
                            case 3:
                                decoratedProducts.add(new DiscountDecorator(product));
                                break;
                            default:
                                decoratedProducts.add((ProductDecorator) product);
                        }
                    }
                    break;
                case 3:
                    // Payment
                    System.out.println("\nPayment:");
                    System.out.println("Select Payment Method:");
                    System.out.println("1. Credit Card");
                    System.out.println("2. PayPal");
                    System.out.println("3. WebMoney");
                    System.out.print("Enter your choice: ");
                    int paymentMethod = scanner.nextInt();

                    PaymentStrategy paymentStrategy = null;
                    switch (paymentMethod) {
                        case 1:
                            paymentStrategy = new CreditCardPayment();
                            break;
                        case 2:
                            paymentStrategy = new PayPalPayment();
                            break;
                        case 3:
                            paymentStrategy = new WebMoneyPayment();
                            break;
                    }

                    // Set order status using Observer and State patterns
                    ordstatus = "IN PROCESSING";
                    orderStateContext.updateOrderStatus(ordstatus);

                    double totalPrice = 0;
                    for (ProductDecorator product : decoratedProducts) {
                        totalPrice += product.getPrice();
                    }
                    paymentStrategy.pay(totalPrice);

                    // Set order status to SENT
                    ordstatus = "SENT";
                    orderStateContext.updateOrderStatus(ordstatus);
                    break;
                case 4:
                    // Order Status
                    orderStateContext.updateOrderStatus(ordstatus);
                    break;
                case 5:
                    // Confirm the Order
                    System.out.println("\nConfirmation of the Order:");
                    // Set order status to DELIVERED using Observer pattern
                    ordstatus = "DELIVERED";
                    orderStateContext.updateOrderStatus(ordstatus);
                    break;
                case 6:
                    // View Order History
                    System.out.println("\nOrder History:");
//                    ShoppingCartMemento lastOrder = orderHistory.getLastOrder();
//                    if (lastOrder != null) {
//                        System.out.println("Last Order:");
//                        for (Product product : lastOrder.getProducts()) {
//                            System.out.println(product.name + " - $" + product.price);
//                        }
//                    } else {
//                        System.out.println("No order history available.");
//                    }
                    break;
                case 7:
                    // Exit
                    System.out.println("Thank you for using the Online Ordering System. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
