package com.example.kiosk7;

public class TerminateException extends Exception {
    public TerminateException() {
        super("프로그램을 종료합니다.");
    }
}
