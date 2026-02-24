package service;

import model.Product;
import model.Category;
import model.SubCategory;
import repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;

class Sale {
    Product product;
    int qtySold;
    double total;
    String date;

    Sale(Product product, int qtySold) {
        this.product = product;
        this.qtySold = qtySold;
        this.total = product.getPrice() * qtySold;
        this.date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}

public class ProductService {
    private ProductRepository productRepo;
    private List<Sale> sales = new ArrayList<>();

    public ProductService(ProductRepository repo) { this.productRepo = repo; }

    public Product addProduct(String name, int qty, double price, Category category, SubCategory subCategory) {
        int id = productRepo.generateId();
        Product p = new Product(id, name, qty, price, category, subCategory);
        productRepo.addProduct(p);
        return p;
    }

    public void viewProducts() {
        System.out.println("ID | Name | Qty | Price | Category | SubCategory");
        for(Product p : productRepo.getProducts()) {
            System.out.println(p.getId() + " | " + p.getName() + " | " + p.getQuantity() + " | " + p.getPrice()
                    + " | " + p.getCategory().getName() + " | " + p.getSubCategory().getName());
        }
    }

    public void stockIn(int id, int qty) {
        Product p = productRepo.findById(id);
        if(p != null) { p.increaseQuantity(qty); System.out.println("Stock added. New Qty: " + p.getQuantity()); }
        else System.out.println("Product not found!");
    }

    public void stockOut(int id, int qty) {
        Product p = productRepo.findById(id);
        if(p != null) {
            if(p.getQuantity() < qty) System.out.println("Not enough stock!");
            else {
                p.decreaseQuantity(qty);
                sales.add(new Sale(p, qty));
                System.out.println("Sold! Total: $" + (p.getPrice() * qty));
            }
        } else System.out.println("Product not found!");
    }

    public void searchProduct(String nameOrId) {
        Product p = null;
        try { int id = Integer.parseInt(nameOrId); p = productRepo.findById(id); }
        catch(NumberFormatException e) { p = productRepo.findByName(nameOrId); }
        if(p != null) System.out.println("Found: " + p.getName() + " Qty: " + p.getQuantity() + " Price: " + p.getPrice());
        else System.out.println("Product not found!");
    }

    public void viewSalesReport() {
        double totalProfit = 0;
        System.out.println("Product | Qty | Total | Date");
        for(Sale s : sales) {
            System.out.println(s.product.getName() + " | " + s.qtySold + " | " + s.total + " | " + s.date);
            totalProfit += s.total;
        }
        System.out.println("Total Profit: $" + totalProfit);
    }
}