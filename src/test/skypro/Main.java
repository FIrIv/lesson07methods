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
}
