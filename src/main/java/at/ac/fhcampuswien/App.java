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

    public static long[] lcg(long seed){
        final long MODULE = (long) Math.pow(2, 31);
        final long A = 1103515245;
        final int C = 12345;

        long[] randomNumbers = new long[10];

        for(int i=0; i<randomNumbers.length; i++){
            long last = i==0 ? seed : randomNumbers[i-1];
            randomNumbers[i] = ((A * last) + C) % MODULE;
        }

        return randomNumbers;
    }

    public static void guessingGame(int numberToGuess){
        if(numberToGuess > 100 || numberToGuess < 0){
            throw new IllegalArgumentException();
        }

        int guessedNumber = -1;
        int tries = 1;
        try(Scanner scanner = new Scanner(System.in)){
            for(; tries <= 10 && guessedNumber != numberToGuess; tries++){
                guessedNumber = scanner.nextInt();
                if(tries == 10) continue;
                if(guessedNumber > numberToGuess){
                    System.out.println("Guess number " + tries +": The number AI picked is lower than your guess.");
                    continue;
                }
                if(guessedNumber < numberToGuess){
                    System.out.println("Guess number " + tries +": The number AI picked is higher than your guess.");
                }
            }
            tries--;
            if(guessedNumber == numberToGuess){
                System.out.println("Guess number " + tries +": You won wisenheimer!");
            } else {
                System.out.println("Guess number " + tries +": You lost! Have you ever heard of divide & conquer?");
            }
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