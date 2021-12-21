package com.company.controller;

import com.company.list.OrderedList;
import com.company.model.User;

import java.util.List;
import java.util.Scanner;

public class UserController {

    public void run() {

        List<User> list = new OrderedList<>();
        System.out.println("Select operation:");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("0. - Exit!\n" +
                        "1. - Add User\n" +
                        "2. - Delete User by name\n" +
                        "3. - Check if contains by name\n" +
                        "4. - Print All");

                String command = scanner.next();

                switch (command) {
                    case "0":
                        return;

                    case "1":
                        System.out.println("Write user name:");
                        list.add(new User(scanner.next()));
                        System.out.println("Result after operation:\n");
                        for (User user : list) {
                            System.out.println(user);
                        }
                        break;

                    case "2":
                        System.out.println("Write exist user name");
                        list.remove(new User(scanner.next()));
                        System.out.println("Result after operation:\n");
                        for (User user : list) {
                            System.out.println(user);
                        }
                        break;


                    case "3":
                        System.out.println("Write user name");
                        if (list.contains(new User(scanner.next()))) {
                            System.out.println("User was found");
                        } else {
                            System.out.println("User is not exist");
                        }
                        System.out.println("Result after operation :");
                        for (User user : list) {
                            System.out.println(user);
                        }
                        break;

                    case "4":
                        System.out.println("All users:");
                        for (User user : list) {
                            System.out.println(user);
                        }

                        break;
                }
            } catch (Exception e) {
                System.out.println("!!!INCORRECT INPUT!!!");
            }
        }
    }
}
