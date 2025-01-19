package com.example.kiosk5;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();

        List<MenuItem> burgerItems = new ArrayList<>();

        burgerItems.add(new MenuItem("ShackBurger","6.9", "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgerItems.add(new MenuItem("SmokeShack","8.9", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgerItems.add(new MenuItem("Cheeseburger","6.9", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgerItems.add(new MenuItem("Hamburger","5.4", "비프패티를 기반으로 야채가 들어간 기본버거"));
        menu.addMenu("Burgers", burgerItems);

        List<MenuItem> drinkItems = new ArrayList<>();

        drinkItems.add(new MenuItem("Coke","2.0", "코카콜라에서 나온 코카콜라"));
        drinkItems.add(new MenuItem("Sprite","2.0", "톡 쏘는 스프라이트"));
        drinkItems.add(new MenuItem("Pepsi","2.0", "펩시콜라에서 나온 펩시콜라"));
        drinkItems.add(new MenuItem("OrangeJuice","2.0", "아침엔 오랜지주스"));
        menu.addMenu("Drinks", drinkItems);

        List<MenuItem> dessertItems = new ArrayList<>();

        dessertItems.add(new MenuItem("ChocoCake","3.2", "달달한 초코케이크"));
        dessertItems.add(new MenuItem("BananaCake","3.4", "먹으면 바나나 안바나나"));
        dessertItems.add(new MenuItem("OrangeCake","3.0", "사장님도 안먹어본 오랜지케이크"));
        dessertItems.add(new MenuItem("CheeseCake","3.1", "코스트코 치즈케이크"));
        menu.addMenu("Desserts", dessertItems);

        Kiosk kiosk = new Kiosk(menu);
        kiosk.start();

    }
}