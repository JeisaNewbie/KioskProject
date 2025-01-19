package com.example.kiosk5;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private final Menu menu;

    public Kiosk(Menu menu) {
        this.menu = menu;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        List<MenuItem> menuItems;
        int input;

        while(true) {
            try {
                menu.printMenu();
                input = Integer.parseInt(scanner.nextLine());

                if (input == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    return;
                }

                menuItems = menu.getCategory(Category.values()[input - 1]);
                MenuItem.printMenuItems(menuItems, Category.values()[input - 1]);
                input = Integer.parseInt(scanner.nextLine());

                if (input == 0) {
                    continue;
                }

                MenuItem.printMenuItem(menuItems.get(input - 1), input);

            } catch (Exception e) {
                exceptionHandler(e);
            }
        }
    }

    private void exceptionHandler(Exception e) {
        if (e instanceof NumberFormatException)
            System.out.println("숫자를 입력하세요.");
        else if (e instanceof IndexOutOfBoundsException)
            System.out.println("잘못된 번호 입니다.");
        else
            e.printStackTrace();
    }
}
