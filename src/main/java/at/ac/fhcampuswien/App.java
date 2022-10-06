package at.ac.fhcampuswien;

import java.util.Random;
import java.util.Scanner;

public class App {

    public static void oneMonthCalendar(int days, int firstWeekday){
        printCalendarInset(firstWeekday);
        for(int i=1; i<=days; i++){
            printDay(i);
            if(isSunday(i, firstWeekday) || isLastDay(i, days)) System.out.println();
        }
    }

    private static void printDay(int day){
        if(day < 10){
            System.out.print(" ");
        }
        System.out.print(day + " ");
    }

    private static void printCalendarInset(int firstWeekday){
        for(int i=0; i<3*(firstWeekday-1); i++) {
            System.out.print(" ");
        }
    }

    private static boolean isSunday(int day, int initialWeekday){
        return ((day + initialWeekday) % 7 == 1);
    }

    private static boolean isLastDay(int currentDay, int maxDay){
        return currentDay == maxDay;
    }
    public static void main(String[] args) {
        // test your method implementations here
        // make method calls
        // print their results
        // etc.
    }
}