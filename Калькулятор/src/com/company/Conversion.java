package com.company;

import static java.lang.Math.abs;

public class Conversion {

    public static int Conversion_to_arabic_num(String str)
    {
        String sign_of_num = "";
        String s = str;
        if (str.startsWith("-") == true)//проверили на отрицательное значение
        {
            sign_of_num = "-";
            s = str.substring(1);
        }

        int numerus = 0;
        int[] x = new int[s.length()];
        for ( int i = 0; i < x.length; i++ )
        {
            switch(s.charAt(i))
            {
                case 'I': x[i] = 1; break;
                case 'V': x[i] = 5; break;
                case 'X': x[i] = 10; break;
                case 'L': x[i] = 50; break;
                case 'C': x[i] = 100; break;
                case 'D': x[i] = 500; break;
                case 'M': x[i] = 1000; break;
            }
        }

        for ( int i = 0; i < x.length - 1; i++ )
        {
            if (x[i] < x[i + 1])
                numerus -= x[i];
            if (x[i] >= x[i + 1])
                numerus += x[i];
        }
        numerus += x[x.length - 1];

        if (sign_of_num == "-")
            numerus *= -1;//вернули числу отрицательное значение

        String str_new = Conversion_to_roman_num(numerus);
        if (str_new.equals(str) == false)//проверили правильность написания римского числа
        {
            Oblom.PoslednieSlova();
        }

        return numerus;
    }

    public static String Conversion_to_roman_num(int num)
    {
        String romannum = "";
        String sign_of_num = "";

        if (num < 0)
            sign_of_num = "-";//проверка на отрицательное значение

        num = abs(num);
        if (num == 0 || num > 3999)//большие римские числа редко используют, и для больших значений нужны специальные символы, не входящие в латинский алфавит
        {
            Oblom.PoslednieSlova();
        }

        int num_1 = num % 10;
        switch(num_1)
        {

            case 1: romannum = "I" + romannum; break;
            case 2: romannum = "II" + romannum; break;
            case 3: romannum = "III" + romannum; break;
            case 4: romannum = "IV" + romannum; break;
            case 5: romannum = "V" + romannum; break;
            case 6: romannum = "VI" + romannum; break;
            case 7: romannum = "VII" + romannum; break;
            case 8: romannum = "VIII" + romannum; break;
            case 9: romannum = "IX" + romannum; break;
            case 0: default: romannum = romannum; break;
        }
        int num_10 = (num % 100) - num_1;
        switch(num_10)
        {

            case 10: romannum = "X" + romannum; break;
            case 20: romannum = "XX" + romannum; break;
            case 30: romannum = "XXX" + romannum; break;
            case 40: romannum = "XL" + romannum; break;
            case 50: romannum = "L" + romannum; break;
            case 60: romannum = "LX" + romannum; break;
            case 70: romannum = "LXX" + romannum; break;
            case 80: romannum = "LXXX" + romannum; break;
            case 90: romannum = "XC" + romannum; break;
            case 0: default: romannum = romannum; break;
        }
        int num_100 = (num % 1000) - num_10 - num_1;
        switch(num_100) {

            case 100:
                romannum = "C" + romannum;
                break;
            case 200:
                romannum = "CC" + romannum;
                break;
            case 300:
                romannum = "CCC" + romannum;
                break;
            case 400:
                romannum = "CD" + romannum;
                break;
            case 500:
                romannum = "D" + romannum;
                break;
            case 600:
                romannum = "DC" + romannum;
                break;
            case 700:
                romannum = "DCC" + romannum;
                break;
            case 800:
                romannum = "DCCC" + romannum;
                break;
            case 900:
                romannum = "CM" + romannum;
                break;
            case 0:
            default:
                romannum = romannum;
                break;
        }
        int num_1000 = (num % 10000) - num_100 - num_10 - num_1;
        switch(num_1000) {

            case 1000:
                romannum = "M" + romannum;
                break;
            case 2000:
                romannum = "MM" + romannum;
                break;
            case 3000:
                romannum = "MMM" + romannum;
                break;
            case 0:
            default:
                romannum = romannum;
                break;
        }

        return sign_of_num + romannum;
    }
}
