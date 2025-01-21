package com.example.kiosk7;

import java.util.List;
import java.util.Scanner;

public class OrdersUtils {
    public static void printOrderMenu(List<MenuItem> orderList) {
        if (orderList.isEmpty()) {
            return;
        }

        System.out.println();
        System.out.println("[ ORDER MENU ]");
        System.out.println(Category.values().length + 1 + ". Orders       | 장바구니를 확인 후 주문합니다.");
        System.out.println(Category.values().length + 2 + ". Cancel       | 진행중인 주문을 취소합니다.");
    }

    public static void printToAddOrNot() {
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인        2. 취소");
    }

    public static void checkOrderOrNot(List<MenuItem> orderList) {
        System.out.println("아래와 같이 주문 하시겠습니까?\n");
        System.out.println("[ Orders ]");
        for (MenuItem menuItem : orderList) {
            System.out.printf("""
                        %-14s| W %s | %s
                        """
                    , menuItem.getName(), menuItem.getPrice(), menuItem.getDescription());
        }
        System.out.println();
        System.out.println("[ Total ]");
        System.out.printf("W %.2f\n\n", countTotalPrice(orderList)); // 총합 출력 함수 추가
        System.out.println("1. 주문      2. 메뉴판");
    }

    private static double countTotalPrice(List<MenuItem> orderList) {
        double totalPrice = 0;

        for (MenuItem menuItem : orderList) {
            totalPrice += Double.parseDouble(menuItem.getPrice());
        }

        return totalPrice;
    }

    public static void terminateOrder(List<MenuItem> orderList) {
        Scanner scanner = new Scanner(System.in);
        int input;

        while (true) {
            JobCategory.selectJobCategory();
            try {
                input = Integer.parseInt(scanner.nextLine());
                if (0 < input && input <= JobCategory.values().length) {
                    System.out.printf("주문이 완료되었습니다. 금액은 W %.3f 입니다.\n\n", JobCategory.discountRate(JobCategory.values()[input - 1], OrdersUtils.countTotalPrice(orderList)));
                    break;
                }
            } catch (Exception e) {
                System.out.println("잘못된 번호 입니다.");
            }
        }
    }
}
