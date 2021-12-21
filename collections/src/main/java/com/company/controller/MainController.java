package com.company.controller;


import java.util.Scanner;

public class MainController {

    public void run() {

        IntegerController integerController = new IntegerController();
        UserController userController = new UserController();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Select the type of data you want to work with\n" +
                        "0. - Exit\n" +
                        "1. - type: Integer\n" +
                        "2. - type: an object User");

                String command = scanner.next();

                switch (command) {
                    case "0":
                        return;

                    case "1":
                        integerController.run();
                        break;

                    case "2":
                        userController.run();
                        break;

                }
            } catch (Exception e) {
                System.out.println("!!!INCORRECT INPUT!!!");
            }
        }
    }
}
