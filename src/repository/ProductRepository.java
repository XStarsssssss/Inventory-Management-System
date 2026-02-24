package repository;

import model.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private List<Product> products = new ArrayList<>();
    private static ProductRepository instance;
    private int nextId = 1;

    private ProductRepository() {}
    public static ProductRepository getInstance() {
        if(instance == null) instance = new ProductRepository();
        return instance;
    }

    public int generateId() { return nextId++; }
    public void addProduct(Product p) { products.add(p); }
    public List<Product> getProducts() { return products; }
    public Product findById(int id) {
        return products.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }
    public Product findByName(String name) {
        return products.stream().filter(p -> p.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }
}