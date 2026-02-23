package model;

public class Product extends Item {
    private int quantity;
    private double price;
    private Category category;
    private SubCategory subCategory;

    public Product(int id, String name, int quantity, double price, Category category, SubCategory subCategory) {
        super(id, name);
        this.quantity = quantity;
        this.price = price;
        this.category = category;
        this.subCategory = subCategory;
    }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void increaseQuantity(int qty) { this.quantity += qty; }
    public void decreaseQuantity(int qty) { this.quantity -= qty; }

    public double getPrice() { return price; }
    public Category getCategory() { return category; }
    public SubCategory getSubCategory() { return subCategory; }
}