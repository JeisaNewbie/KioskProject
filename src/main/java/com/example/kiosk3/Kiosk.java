package com.example.kiosk3;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    List<MenuItem> menuItems;

    public Kiosk(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int input;

        while(true) {
            System.out.println("[ SHAKESHACK MENU ]");
            printAll(menuItems);

            try {
                input = Integer.parseInt(scanner.nextLine());

                if (input == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    return;
                }

                print(menuItems.get(input - 1), input);
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력하세요");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("잘못된 번호 입니다.");
            }
        }
    }

    private static void printAll(List<MenuItem> menuItems) {
        int i = 1;
        for (MenuItem menuItem : menuItems) {
            System.out.printf("%d. %-14s| W %s | %s\n", i++, menuItem.getName(), menuItem.getPrice(), menuItem.getDescription());
        }
        System.out.println("0. 종료      | 종료");
    }

    private static void print(MenuItem menuItem, int i) {
        System.out.printf("""
                        ==============================================================
                        %d. %-14s| W %s | %s
                        ==============================================================

                        """
                , i, menuItem.getName(), menuItem.getPrice(), menuItem.getDescription());
    }
}
