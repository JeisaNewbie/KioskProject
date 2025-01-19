package com.example.kiosk7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Orders {
    private static final List<MenuItem> menuItems = new ArrayList<>();

    public static void printToAddOrNot() {
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인        2. 취소");
    }

    public static boolean isEmpty() {
        return menuItems.isEmpty();
    }

    public static void printOrderMenu() {
        if (menuItems.isEmpty()) {
            return;
        }

        System.out.println();
        System.out.println("[ ORDER MENU ]");
        System.out.println(Category.values().length + 1 + ". Orders       | 장바구니를 확인 후 주문합니다.");
        System.out.println(Category.values().length + 2 + ". Cancel       | 진행중인 주문을 취소합니다.");
    }

    public static void checkOrderOrNot() {
        System.out.println("아래와 같이 주문 하시겠습니까?\n");
        System.out.println("[ Orders ]");
        for (MenuItem menuItem : menuItems) {
            System.out.printf("""
                        %-14s| W %s | %s
                        """
                    , menuItem.getName(), menuItem.getPrice(), menuItem.getDescription());
        }
        System.out.println();
        System.out.println("[ Total ]");
        System.out.printf("W %.2f\n\n", countTotalPrice()); // 총합 출력 함수 추가
        System.out.println("1. 주문      2. 메뉴판");
    }

    public static void selectJobCategory () {
        System.out.println("할인 정보를 입력해주세요.");
        for (JobCategory jobCategory : JobCategory.values()) {
            System.out.printf("%d. %8s : %.0f%%\n", jobCategory.ordinal() + 1, jobCategory.name(), jobCategory.getValue());
        }
    }

    private static double countTotalPrice() {
        double totalPrice = 0;

        for (MenuItem menuItem : menuItems) {
            totalPrice += Double.parseDouble(menuItem.getPrice());
        }

        return totalPrice;
    }

    public static void terminateOrder() {
        Scanner scanner = new Scanner(System.in);
        int input;

        while (true) {
            selectJobCategory();
            try {
                input = Integer.parseInt(scanner.nextLine());
                if (0 < input && input <= JobCategory.values().length) {
                    System.out.printf("주문이 완료되었습니다. 금액은 W %.3f 입니다.\n\n", JobCategory.discountRate(JobCategory.values()[input - 1], countTotalPrice()));
                    break;
                }
            } catch (Exception e) {
                System.out.println("잘못된 번호 입니다.");
            }
        }
    }

    public static void clearOrderList() {
        menuItems.clear();
    }

    public static void addToOrderList(MenuItem menuItem) {
        menuItems.add(menuItem);
    }
}
