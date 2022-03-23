package test.skypro;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
	    // задание 1
        int year = 2020;
        System.out.println(testYear(year));

        // задание 2
        // 0 — iOS или 1 — Android
        byte clientOS = 0;
        int clientDeviceYear = 2015;
        System.out.println(testOS(clientOS, clientDeviceYear));

        // задание 3

    }

    public static String testYear(int year) {
        if (year % 4 != 0 || (year % 100 == 0 && year % 400 != 0)){
            return(year + " - не високосный год. ");
        } else {
            return(year + " - високосный год. ");
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
}
