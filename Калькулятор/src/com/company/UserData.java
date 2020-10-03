package com.company;

import java.util.Scanner;

public class UserData {

    public String a;
    public String b;
    public String sign;
    public int x;
    public int y;
    public boolean rimskaya_boolochka = false;

    public void Beliberda() {
        Scanner sc = new Scanner(System.in);
        String beliberda = sc.nextLine();
        //System.out.println(beliberda);

        if (beliberda.length() > 20)
            Oblom.PoslednieSlova();//проверили строку на количество символов

        for (int i = 0; i < beliberda.length(); i++) {
            if (ValidChar.valid_symbol.indexOf(beliberda.charAt(i)) == -1)//т. е. в строке valid_symbol символ не встречается
            {
                Oblom.PoslednieSlova();
            }
        }//проверили строку на наличие недопустимых символов

        int count_sign = 0;//счетчик арифметических знаков
        int index_sign = 0;//расположение арифметического знака в строке пользователя
        for (int i = 0; i < beliberda.length(); i++) {
            if (ValidChar.valid_sign.indexOf(beliberda.charAt(i)) != -1)//т. е. в строке valid_sign встречается знак
            {
                count_sign++;
                index_sign = i;
            }
        }
        if (count_sign != 1)
            Oblom.PoslednieSlova();//проверили, что есть только один арифметический знак и получили его индекс в строке
        if (index_sign == 0 || index_sign == beliberda.length() - 1)
            Oblom.PoslednieSlova();//проверили, что первый и последний символы не арифметический знак

        //Теперь разделим строку на три подстроки
        this.a = beliberda.substring(0, index_sign);
        this.sign = beliberda.substring(index_sign, index_sign + 1);
        this.b = beliberda.substring(index_sign + 1);
        //В строках a и b должно быть по одному числу, оба числа должны содержать только арабские цифры или латинские буквы, пробелы снаружи убираем
        this.a = this.a.trim();
        this.b = this.b.trim();

        boolean bool_a = true;
        boolean bool_b = true;

        for (int i = 0; i < a.length(); i++)
            if ( ValidChar.valid_arabian_number.indexOf(this.a.charAt(i)) == -1 )
                bool_a = false;
        for (int i = 0; i < b.length(); i++)
            if ( ValidChar.valid_arabian_number.indexOf(this.b.charAt(i)) == -1 )
                bool_b = false;

        boolean bulka = bool_a && bool_b;

        if (bulka == true)
        {
            this.x = Num(this.a);
            this.y = Num(this.b);
        }
        else
        {
            this.x = Conversion.Conversion_to_arabic_num(this.a);
            this.y = Conversion.Conversion_to_arabic_num(this.b);
            this.rimskaya_boolochka = true;
        }
    }

    public static int Num(String n)
    {
        int t = Integer.parseInt(n);
        return t;
    }
}