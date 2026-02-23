package model;

import java.util.ArrayList;
import java.util.List;

public class Category extends Item {
    private List<SubCategory> subCategories = new ArrayList<>();

    public Category(int id, String name) {
        super(id, name);
    }

    public void addSubCategory(SubCategory sc) { subCategories.add(sc); }

    public List<SubCategory> getSubCategories() { return subCategories; }
}