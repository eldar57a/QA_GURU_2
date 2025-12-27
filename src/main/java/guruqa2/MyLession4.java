package guruqa2;

public class MyLession4 {


    public static void main(String[] args){

        int bananas = 5;
        int apples = 9;
        double oranges = 4.5;

        System.out.println("===== Арифметические операции ( +, -, /, *,) \n над двумя примитивами типа int =====");
        System.out.println("Сложение + " + (bananas + apples));
        System.out.println("Вычитание - " + (apples - bananas));
        System.out.println("Умножение * " + (apples * bananas));
        System.out.println("Деление / " + (apples / bananas));

        System.out.println("\n===== Арифметические операции ( +, -, /, *,) \n над int и double в одном выражении =====");
        System.out.println("Сложение + " + (oranges + apples));
        System.out.println("Вычитание - " + (apples - oranges));
        System.out.println("Умножение * " + (apples * oranges));
        System.out.println("Деление / " + (apples / oranges));

        System.out.println("\n===== Применение логических операций ( < , >, >=, <= ) =====");

        if (apples < bananas) {
            System.out.println(" bananas меньше apples");
        } else if (bananas <= oranges) {
            System.out.println("bananas меньше oranges");
        } else {
            System.out.println("bananas больше всего");
        }

        System.out.println("\n===== Переполнение при арифметической операции =====");

        short taxi = 32767;
        short bus = 150;
        short y = (short) (taxi + bus);

        if (y == 32917)
        {
            System.out.println("Памяти хватает для арифметической операции");
        }
        else
        {
            System.out.println("Результат переполненеия арифметической операции = "+ y);
        }

    }

}
