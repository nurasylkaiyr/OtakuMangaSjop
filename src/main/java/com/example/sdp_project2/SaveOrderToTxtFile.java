package com.example.sdp_project2;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SaveOrderToTxtFile {
    private String filename;

    public SaveOrderToTxtFile(String filename) {
        this.filename = filename;
    }

    public void execute(List<Product> products) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (Product product : products) {
                writer.write(product.name + " - $" + product.price + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
