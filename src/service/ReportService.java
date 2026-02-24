package service;

import model.Product;
import java.util.ArrayList;
import java.util.List;

public class ReportService {
    private List<Product> lowStockReports = new ArrayList<>();

    public void reportLowStock(Product p) {
        lowStockReports.add(p);
        System.out.println("Low stock reported for: " + p.getName());
    }

    public void viewReports() {
        System.out.println("=== Staff Low Stock Reports ===");
        for(Product p : lowStockReports)
            System.out.println(p.getName() + " | Qty: " + p.getQuantity());
    }
}