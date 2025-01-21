package com.example.kiosk7;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private final Menu menu;

    public Kiosk(Menu menu) {
        this.menu = menu;
    }

    public void start() throws TerminateException {
        Scanner scanner = new Scanner(System.in);
        Orders orders = new Orders();
        List<MenuItem> menuItems;
        Page page = Page.CATEGORY;
        int categoryIndex = 0;
        int itemIndex;
        int orderIndex;

        while(true) {
            try {
                switch (page) {
                    case CATEGORY: // Category 출력
                        Menu.printMenu();
                        OrdersUtils.printOrderMenu(orders.getOrderList());
                        System.out.println("0. 종료      | 종료");
                        System.out.println();

                        categoryIndex = Integer.parseInt(scanner.nextLine());
                        throwIfOutOfBound(categoryIndex, orders); // 범위를 벗어난 입력값에 대한 예외 체크

                        if (categoryIndex <= Category.values().length) {
                            page = Page.MAIN;
                        } else if (categoryIndex == Category.values().length + 1) {
                            page = Page.ORDER;
                        } else if (categoryIndex == Category.values().length + 2) {
                            page = Page.CANCEL;
                        }
                        break;

                    case MAIN: // Main Menu 선택창
                        menuItems = menu.getCategory(Category.values()[categoryIndex - 1]);
                        MenuItem.printMenuItems(menuItems, Category.values()[categoryIndex - 1]);

                        itemIndex = Integer.parseInt(scanner.nextLine());

                        if (itemIndex == 0) {
                            page = Page.CATEGORY;
                            continue;
                        }

                        MenuItem.printMenuItem(menuItems.get(itemIndex - 1), itemIndex);

                        OrdersUtils.printToAddOrNot(); //장바구니 추가 메세지 출력

                        orderIndex = Integer.parseInt(scanner.nextLine());
                        if (orderIndex == 1) {
                            orders.addToOrderList(menuItems.get(itemIndex - 1));
                            page = Page.CATEGORY;
                        } else if (orderIndex == 2) {
                            page = Page.CATEGORY;
                        } else {
                            System.out.println("확인 혹은 취소를 눌러주세요");
                        }
                        break;

                    case ORDER: // Category 선택창에서 Order 선택시 나오는 Order 선택창
                        OrdersUtils.checkOrderOrNot(orders.getOrderList()); //주문확인 선택창 출력

                        int payIndex = Integer.parseInt(scanner.nextLine());

                        if (payIndex == 1) {
                            OrdersUtils.terminateOrder(orders.getOrderList());
                            orders.clearOrderList();
                            page = Page.CATEGORY;
                        } else if (payIndex == 2) {
                            page = Page.CATEGORY;
                        } else {
                            System.out.println("주문 혹은 메뉴판을 눌러주세요");
                        }
                        break;

                    case CANCEL: // Category 선택창에서 Cancel 선택시 장바구니를 비우고 다시 Category 선택창 출력
                        orders.clearOrderList();
                        page = Page.CATEGORY;
                }

            } catch (Exception e) {
                exceptionHandler(e);
            }
        }
    }

    private void throwIfOutOfBound(int categoryIndex, Orders orders) throws Exception {
        if (categoryIndex < 0) // 0 미만의 수 입력시 예외
            throw new IndexOutOfBoundsException();
        if (categoryIndex == 0) //프로그램 종료
            throw new TerminateException();
        if (orders.isEmpty() && categoryIndex > Category.values().length) { //Orders가 비어있고 categoryIndex가 Main Menu의 범위를 벗어나면 예외
            throw new IndexOutOfBoundsException();
        } else if (!orders.isEmpty() && (categoryIndex > Category.values().length + 2)) { // Orders가 비어있지 않고 categoryIndex가 Main Menu + Order Menu의 범위를 벗어나면 예외
            throw new IndexOutOfBoundsException();
        }
    }

    private void exceptionHandler(Exception e) throws TerminateException {
        if (e instanceof NumberFormatException)
            System.out.println("숫자를 입력하세요.");
        else if (e instanceof IndexOutOfBoundsException)
            System.out.println("잘못된 번호 입니다.");
        else if (e instanceof TerminateException)
            throw (TerminateException) e;
        else
            e.printStackTrace();
    }

    private enum Page {
        CATEGORY, MAIN, ORDER, CANCEL
    }
}
