package com.shpp.cs.vhudzal.consoletest;

import com.shpp.cs.a.console.TextProgram;

import java.util.Scanner;

/**
 * Created by ВЛАДИМИР on 29.11.2015.
 */
public class Assignment2Part1 extends TextProgram{
    public void run() {
        /**
         создание констант типа double;
          */
        double a, b, c;
        double D;
        /**
          создание главных надписей: тип уравнения; формула уравнения; построковые запросы о вводе данных решения уравнения
         */
        System.out.println("The program solves quadratic equation types:");
        System.out.println("ax^2 + bx + c = 0");
        System.out.println("Please Enter a, b и c:");
        Scanner in = new Scanner(System.in);
        System.out.println("Please Enter a:");
        a = in.nextDouble();
        System.out.println("Please Enter b:");
        b = in.nextDouble();
        System.out.println("Please Enter c:");
        c = in.nextDouble();
        /**
         формула на хождения "Дискриминанты";
         */
        D = b * b - 4 * a * c;
        /**
         создание условий нахождения дискриминанты, а именно: если D больше нуля - будет существовать 2 креня;
         если D равно нулю - будет найден один корень; если D меньше нуля - результат не существует. Вывод указания
         колличества кореней и их результат;
         */
        if (D > 0) {
            double x1, x2;
            x1 = (-b - Math.sqrt(D)) / (2 * a);
            x2 = (-b + Math.sqrt(D)) / (2 * a);
            System.out.println("There are two roots:" + "x1" + x1 +"\n"+ "x2" +x2);
        }
        else if (D == 0) {
            double x;
            x = -b / (2 * a);
            System.out.println("There is one root:" + x);
        }
        else {
            System.out.println("There are no real roots");
        }
    }
}