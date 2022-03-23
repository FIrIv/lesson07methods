package test.skypro;

import java.time.LocalDate;

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
}
