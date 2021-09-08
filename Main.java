package com.company;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    static Scanner s = new Scanner(System.in);
    static int Number1;
    static int Number2;
    static char operand;
    static int result;


    public static void main(String[] args) {
        System.out.println("Введите два параметра с которыми вы хотите провести арифметическую операцию в формате '5+5' или 'V+V' ");

        String input = s.nextLine();

        char[] danniye = new char[10];


        for (int i = 0; i < input.length(); i++) {

            danniye[i] = input.charAt(i);
            if (danniye[i] == '+') {
                operand = '+';
            }
            if (danniye[i] == '-') {
                operand = '-';
            }
            if (danniye[i] == '*') {
                operand = '*';
            }
            if (danniye[i] == '/') {
                operand = '/';
            }
        }


        String under_charString = String.valueOf(danniye);
        String[] elements = under_charString.split("[+-/*]");
        if (elements.length == 1) {
            throw new RuntimeException("Строка не является математической операцией");
        } else if (elements.length > 2) {
            throw new RuntimeException("Недопустимое число вводных параметов");
        }


        String string00 = elements[0].trim();
        String string02 = elements[1].trim();



        Number1 = Morth.romanToNumber(string00);
        Number2 = Morth.romanToNumber(string02);

        if (Number1 < 0 && Number2 < 0) {
            result = 0;
            Number1 = Integer.parseInt(string00);
            Number2 = Integer.parseInt(string02);
            result = Calc.Operation(Number1, Number2, operand);
            System.out.println("Результат арабских цифр:");
            System.out.print(result);
        } else {
            if (Number1 == -1||Number2 == -1) {
                throw new RuntimeException("Используются одновременно разные системы исчисления");
            }
                result = Calc.Operation(Number1, Number2, operand);
                System.out.println("Результат для римских цифр:");
            if( result<0 ){
                throw new RuntimeException("Римские числа не могут быть отрицательными");
            }
                String resultRoman = Morth.numToRoman(result);

                System.out.println(resultRoman);

        }

    }
}

