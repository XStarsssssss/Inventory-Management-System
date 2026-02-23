package repository;

import model.Category;
import model.SubCategory;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {
    private List<Category> categories = new ArrayList<>();
    private static CategoryRepository instance;
    private int nextId = 1;

    private CategoryRepository() {}

    public static CategoryRepository getInstance() {
        if(instance == null) instance = new CategoryRepository();
        return instance;
    }

    public int generateId() { return nextId++; }

    public void addCategory(Category c) { categories.add(c); }

    public List<Category> getCategories() { return categories; }

    public Category findCategoryById(int id) {
        return categories.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    public SubCategory findSubCategoryById(Category category, int subId) {
        return category.getSubCategories().stream().filter(sc -> sc.getId() == subId).findFirst().orElse(null);
    }
}