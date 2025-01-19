package com.example.kiosk6;

import java.util.List;

public class MenuItem {
    private String name;
    private String price;
    private String description;

    public MenuItem(String name, String price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public static void printMenuItems(List<MenuItem> menuItems, Category category) {

        System.out.printf("[ %s MENU ]\n", category.toString());
        int i = 1;
        for (MenuItem menuItem : menuItems) {
            System.out.printf("%d. %-14s| W %s | %s\n", i++, menuItem.getName(), menuItem.getPrice(), menuItem.getDescription());
        }
        System.out.printf("0. %-12s| 뒤로가기\n", "뒤로가기");
    }

    public static void printMenuItem(MenuItem menuItem, int i) {
        System.out.printf("""
                        ==============================================================
                        %d. %-14s| W %s | %s
                        ==============================================================

                        """
                , i, menuItem.getName(), menuItem.getPrice(), menuItem.getDescription());
    }


}
