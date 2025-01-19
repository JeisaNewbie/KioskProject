package com.example.kiosk4;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class Menu {
    private final LinkedHashMap<String, List<MenuItem>> menu;

    public Menu() {
        menu = new LinkedHashMap<>();
    }

    public void addMenu(String menuName, List<MenuItem> menuItems) {
        menu.put(menuName, menuItems);
    }

    Set<String> getCategories() {
        return menu.keySet();
    }

    public List<MenuItem> getCategory(Category category) {
        return menu.get(category.toString());
    }

    public void printMenu() {
        Set<String> categories = getCategories();
        int i = 1;
        for (String category : categories) {
            System.out.println(i++ + ". " + category);
        }
        System.out.println("0. 종료      | 종료");
    }
}
