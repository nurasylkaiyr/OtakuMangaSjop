package com.example.sdp_project2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MangaShopGUI extends JFrame {
    private ShoppingCart cart;
    private JTextArea cartTextArea;

    public MangaShopGUI() {
        cart = ShoppingCart.getInstance();

        setTitle("Otaku Manga Shop");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JTextArea productCatalog = new JTextArea();
        productCatalog.setEditable(false);
        productCatalog.setText("Product Catalog:\n1. Chainsaw man Vol.12 - $12\n2. My Hero Academia Vol.35 - $10\n3. Spy X Family Vol.10 - $16");

        cartTextArea = new JTextArea();
        cartTextArea.setEditable(false);

        JButton addToCartButton = new JButton("Add to Cart");
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement adding to cart
            }
        });

        panel.add(productCatalog, BorderLayout.NORTH);
        panel.add(cartTextArea, BorderLayout.CENTER);
        panel.add(addToCartButton, BorderLayout.SOUTH);

        getContentPane().add(panel);
    }

    // Add methods to update cartTextArea and handle user actions

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MangaShopGUI().setVisible(true);
            }
        });
    }
}
