package test.skypro;

import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
	    // задание 1
        int year = 2020;
        System.out.println(year + " : " + testYear(year));

        // задание 2
        // 0 — iOS или 1 — Android
        byte clientOS = 0;
        int clientDeviceYear = 2019;
        System.out.println(clientDeviceYear + " : " + testOS(clientOS, clientDeviceYear));

        // задание 3
        int distance = 60;
        System.out.println(distance + " км : " + calculateDeliveryDays (distance));

        // задание 4
        String s = "aabccddefgghiijjkk";
        findRepeats(s);

        // задание 5
        int[] arr = {1,3,5,7,9,2,4,6,8,0};
        System.out.println("Первоначальный массив : " + Arrays.toString(arr));
        reverseArray(arr);
        System.out.println("В обратном порядке : " + Arrays.toString(arr));

        // Строки, задание 5
        String fullName = "Ivanov Ivan Ivanovich";
        String lastName = fullName.substring(0,fullName.indexOf(' '));
        String firstName = fullName.substring(fullName.indexOf(' ')+1,fullName.lastIndexOf(' '));
        String middleName = fullName.substring(fullName.lastIndexOf(' ')+1,fullName.length());
        System.out.println("Имя сотрудника - " + firstName);
        System.out.println("Отчество сотрудника - " + middleName);
        System.out.println("Фамилия сотрудника - " + lastName);

        // Строки, задание 6
        fullName = "ivanov ivan ivanovich";
        char[] fio = fullName.toCharArray();
        for (int ch = 0; ch < fio.length; ch++) {
            if (ch == 0 || fio[ch-1] == ' ') fio[ch] = Character.toUpperCase(fio[ch]);
            //else fio[ch] = Character.toLowerCase(fio[ch]); // если остальные буквы могут быть большими
        }
        fullName = String.copyValueOf(fio); // можно и String.valueOf(fio); работает аналогично, но "Copy как будто читается понятнее"
        // fullName = Arrays.toString(fio); // выводит как [I, v, a, n, o, v,  , I, v, a, n,  , I, v, a, n, o, v, i, c, h]
        System.out.println("Верное написание Ф.И.О. сотрудника с заглавных букв - " + fullName);

        // Строки, задание 7
        String s1 = "135";
        String s2 = "246";
        StringBuilder st = new StringBuilder();
        for (int pos = 0; pos<s1.length(); pos++) {
            st.append(s1.charAt(pos));
            st.append(s2.charAt(pos));
        }
        System.out.println("Данные строки - " + st);

        // Строки, задание 8
        String letters = "aabccddefgghiijjkk";
        StringBuilder letters2 = new StringBuilder();
        for (int j=0;j<letters.length();j++) {
            if (j==0 || (letters.charAt(j) != letters.charAt(j-1))) letters2.append(letters.charAt(j));
        }
        System.out.println("Строка без повторов - " + letters2);

        // Методы, задание 6
        int countOfDays = 30;
        int [] spendingPerMonth = generateRandomArray(0, 1_000_000, countOfDays);
        float averageSpendingPerDays = countAverageSpendingPerDays(spendingPerMonth, countOfDays);
        System.out.println("Средняя сумма трат за месяц составила " + averageSpendingPerDays + " рублей. ");
    }

    public static String testYear(int year) {
        if (year % 4 != 0 || (year % 100 == 0 && year % 400 != 0)){
            return("Не високосный год. ");
        } else {
            return("Високосный год. ");
        }
    }

    public static String testOS (byte clientOS, int clientDeviceYear) {
        int currentYear = LocalDate.now().getYear();
        if (clientOS == 0) {
            if (clientDeviceYear >= currentYear) {
                return("Обычная версия приложения\n     ОС - iOS");
            } else {
                return("Облегченная версия приложения\n     ОС - iOS");
            }
        } else if (clientOS ==1 ){
            if (clientDeviceYear >= currentYear) {
                return("Обычная версия приложения\n     ОС - Android");
            } else {
                return("Облегченная версия приложения\n     ОС - Android");
            }
        } else {
            return("Ошибка");
        }
    }

    public static String calculateDeliveryDays (int distance) {
        // <=20км - 1 день, <=60км - 2 дня, <=100км - 3 дня и т.д.
        int days = 1;
        if (distance > 20 && distance <=60) days = 2;
        else if (distance > 60 && distance <=100) days = 3;
        else if (distance > 100) return ("Доставка более 100км не производится. ");
        return "Доставка " + days + "дн.";
    }

    public static void findRepeats (String s) {
        for (int i=0; i<s.length()-1; i++) {
            if (s.charAt(i)==s.charAt(i+1)) {
                System.out.println("В строке " + s + " обнаружен дубль : " + s.charAt(i));
                return;
            }
        }
        System.out.println("В строке " + s + " дублей не обнаружено ");
    }

    public static void reverseArray (int[] arr) {
        int temp = 0;
        for (int i=0; i<arr.length/2; i++) {
            temp = arr[i];
            arr[i] = arr[arr.length-i-1];
            arr[arr.length-i-1] = temp;
        }
    }

    public static int[] generateRandomArray (int min, int max, int countOfElements) {
        java.util.Random random = new java.util.Random();
        int[] arr = new int[countOfElements];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(max-min) + min;
        }
        return arr;
    }

    public static float countAverageSpendingPerDays (int[] spendingPerMonth, int countOfDays) {
        return (float)countSumSpendingPerDays(spendingPerMonth) / (float)countOfDays;
    }

    public static int countSumSpendingPerDays(int[] spendingPerMonth) {
        int Sum = 0;
        for (int i=0; i<spendingPerMonth.length; i++) {
            Sum += spendingPerMonth[i];
        }
        return Sum;
    }
}
