package guruqa2;

import java.util.List;

public class Example {

    public static void main(){

        //Числовой
        byte aByte = 0;//8
        short aShort = 0;//16
        int aInt = 0;//32
        long aLong = 0; //64

        //С плавоющей точкой
        float aFloat = 0.0F;
        double aDouble = 0.0;

        //Символьный
        char aChar = 'a';

        //Логический тип
        boolean aBoolean = true;

        //Строка ( и бесконечность других объектов и ссылочных)
        String toBePrint = "Hello word! ";
        List<String> teachers = List.of("Стаинслав, Дмитрий");

        //Операторы
        //Оператор присвоения =
       // String toBePrint = "Hello word! ";
        //Арифметические операторы +-/*% ++ --
        System.out.println(4.0 + 3);
        int result = ++ aInt ;//32
        System.out.println(result);
        // операторы сравнения <> => <=  != ==
        System.out.println(4 != 3);
        //Логические & | && || ^ !
        System.out.println(toBePrint.equals("Hello word!") && aInt == 0);

        //Тернарный оператор

        char sex = 'm';

        String nameChild = sex == 'm' ? "R" : "q";

        //Управляющая конструкция if

        if (sex == 'm'){
            nameChild = "R";

        } else{
            nameChild = "t";
        }

        // Создавать объект new

        String name =  new String("Eldar");


    }
}
