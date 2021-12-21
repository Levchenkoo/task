package com.company.controller;

import com.company.list.OrderedList;

import java.util.List;
import java.util.Scanner;

public class IntegerController {

    public void run() {

        List<Integer> list = new OrderedList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Select operation:\n" +
                        "0. - Exit!\n" +
                        "1. - Add element\n" +
                        "2. - Delete element\n" +
                        "3. - Check if contains\n" +
                        "4. - Print all");

                String command = scanner.next();

                switch (command) {
                    case "0":
                        return;

                    case "1":
                        System.out.println("Enter int:");
                        list.add(scanner.nextInt());
                        System.out.println("Result after operation:\n");
                        for (Integer integer : list) {
                            System.out.println(integer);
                        }
                        break;

                    case "2":
                        System.out.println("Enter exist int:");
                        list.remove((Integer) scanner.nextInt());
                        System.out.println("Result after operation:\n");
                        for (Integer integer : list) {
                            System.out.println(integer);
                        }
                        break;

                    case "3":

                        if (list.contains(scanner.nextInt())) {
                            System.out.println("Contains");
                        } else {
                            System.out.println("Non existent");
                        }
                        System.out.println("Result after operation:\n");
                        for (Integer integer : list) {
                            System.out.println(integer);
                        }
                        break;

                    case "4":
                        System.out.println("All elements: ");
                        for (Integer integer : list) {
                            System.out.println(integer);
                        }
                        break;

                }
            } catch (Exception e) {
                System.out.println("!!!INCORRECT INPUT!!!");
            }

        }
    }
}
