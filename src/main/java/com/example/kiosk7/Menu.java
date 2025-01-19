package com.example.kiosk7;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class Menu {
    private static final LinkedHashMap<String, List<MenuItem>> menu = new LinkedHashMap<>();

    public void addMenu(String menuName, List<MenuItem> menuItems) {
        menu.put(menuName, menuItems);
    }

    public List<MenuItem> getCategory(Category category) {
        return menu.get(category.toString());
    }

    public static void printMenu() {
        Set<String> categories = menu.keySet();
        int i = 1;

        System.out.println("[ MAIN MENU ]");
        for (String category : categories) {
            System.out.println(i++ + ". " + category);
        }
    }
}
