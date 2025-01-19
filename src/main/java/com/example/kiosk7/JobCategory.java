package com.example.kiosk7;

public enum JobCategory {
    국가유공자(10), 군인(5), 학생(3), 일반(0);

    private final double value;

    JobCategory(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public static double discountRate(JobCategory category, double price) {
        return price - price *(category.value / 100);
    }
}
