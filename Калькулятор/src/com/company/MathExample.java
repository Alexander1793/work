package com.company;

public class MathExample {

    public static void Resalt(int a, int b, String x, boolean y)
    {
        int resalt = 0;
        String result_roman;
        if (x.equals("+") == true)
            resalt = a + b;
        if (x.equals("-") == true)
            resalt = a - b;
        if (x.equals("*") == true)
            resalt = a * b;
        if (x.equals("/") == true)
            resalt = a / b;
        if (resalt == 0 || resalt > 3999)
        {
            System.out.println(resalt + " Невозможно отобразить римскими числами");
            return;
        }
        if ( y == true )
        {
            result_roman = Conversion.Conversion_to_roman_num(resalt);
            System.out.println(result_roman);
        }
        else System.out.println(resalt);
    }
}
