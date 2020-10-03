package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    while(true)
        {
            System.out.println("Что посчитать?");
            UserData example = new UserData();
            example.Beliberda();
            if (example.x <= 10 && example.y <= 10)
                MathExample.Resalt(example.x, example.y, example.sign, example.rimskaya_boolochka);
            else System.out.println("Я только до десяти считать умею, ну и таблицу умножения знаю");
        }
    }
}
