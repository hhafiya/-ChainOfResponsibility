package com.stamping;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Task task1 = new TaskImpl("Task 1");
        Task task2 = new TaskImpl("Task 2");
        Task task3 = new TaskImpl("Task 3");

        Signature signature1 = new Signature(task1);
        Signature signature2 = new Signature(task2);
        Signature signature3 = new Signature(task3);

        Group group = new Group(List.of(signature1, signature2, signature3), "group1");

        group.apply();
    }
}

