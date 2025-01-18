package com.example.kiosk2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<MenuItem> menuItems = new ArrayList<>();
        int input;

        menuItems.add(new MenuItem("ShackBurger","6.9", "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack","8.9", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger","6.9", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger","5.4", "비프패티를 기반으로 야채가 들어간 기본버거"));

        while(true) {
            System.out.println("[ SHAKESHACK MENU ]");
            printAll(menuItems);
            input = Integer.parseInt(scanner.nextLine());

            if (input == 0) {
                System.out.println("프로그램을 종료합니다.");
                return;
            }

            try {
                print(menuItems.get(input - 1), input);
            }
            catch(IndexOutOfBoundsException e) {
                System.out.println("잘못된 번호 입니다.");
            }
        }
    }

    public static void printAll(List<MenuItem> menuItems) {
        int i = 1;
        for (MenuItem menuItem : menuItems) {
            System.out.printf("%d. %-14s| W %s | %s\n", i++, menuItem.getName(), menuItem.getPrice(), menuItem.getDescription());
        }
        System.out.println("0. 종료      | 종료");
    }

    public static void print(MenuItem menuItem, int i) {
        System.out.printf("%d. %-14s| W %s | %s\n", i, menuItem.getName(), menuItem.getPrice(), menuItem.getDescription());
    }
}