package com.example.kiosk7;

import java.util.ArrayList;
import java.util.List;

public class Orders {
    private final List<MenuItem> orderList;

    public Orders() {
        this.orderList = new ArrayList<>();
    }

    public List<MenuItem> getOrderList() {
        return orderList;
    }

    public boolean isEmpty() {
        return orderList.isEmpty();
    }


    public void clearOrderList() {
        orderList.clear();
    }

    public void addToOrderList(MenuItem menuItem) {
        orderList.add(menuItem);
    }
}
