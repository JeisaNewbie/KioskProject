package com.example.kiosk4;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    Menu menu;

    public Kiosk(Menu menu) {
        this.menu = menu;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        List<MenuItem> menuItems;
        int input;

        while(true) {
            menu.printMenu();

            //리팩토링 필요
            try {
                input = Integer.parseInt(scanner.nextLine());

                if (input == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    return;
                }
                menuItems = menu.getCategory(Category.values()[input - 1]);

            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력하세요.");
                continue;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("잘못된 번호 입니다.");
                continue;
            }

            MenuItem.printMenuItems(menuItems, Category.values()[input - 1]);
            try {
                input = Integer.parseInt(scanner.nextLine());

                if (input == 0) {
                    continue;
                }

                MenuItem.printMenuItem(menuItems.get(input - 1), input);
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력하세요.");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("잘못된 번호 입니다.");
            }
        }
    }


}
