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

    public static void selectJobCategory () {
        System.out.println("할인 정보를 입력해주세요.");
        for (JobCategory jobCategory : JobCategory.values()) {
            System.out.printf("%d. %8s : %.0f%%\n", jobCategory.ordinal() + 1, jobCategory.name(), jobCategory.getValue());
        }
    }

    public static double discountRate(JobCategory category, double price) {
        return price - price *(category.value / 100);
    }
}
