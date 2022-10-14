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

    public static int randomNumberBetweenOneAndHundred(){
        return (int) (Math.random()*100) + 1;
    }

    public static boolean swapArrays(int[] a, int[] b){
        if(a.length != b.length){
            return false;
        }

        for(int i=0; i<a.length; i++){
            int helper = a[i];
            a[i] = b[i];
            b[i] = helper;
        }

        return true;
    }

    public static String camelCase(String input){
        StringBuilder output = new StringBuilder();
        boolean isFirstOfWord = true;
        for(char character: input.toCharArray()){
                if(isNormalCharacter(character)){
                    if(isFirstOfWord){
                        output.append(toUpper(character));
                        isFirstOfWord = false;
                    } else {
                        output.append(toLower(character));
                    }
                    continue;
                }
                if(character == ' '){
                    isFirstOfWord = true;
                }
        }
        return output.toString();
    }

    private static boolean isNormalCharacter(char x){
        return (x >= 'A' && x<= 'Z') || (x >= 'a' && x<= 'z');
    }

    private static char toUpper(char x){
        if(isNormalCharacter(x)){
            if(x > 'Z'){
                return (char) (x - 32);
            }
            else {
                return x;
            }
        } else {
            throw new IllegalArgumentException("");
        }
    }
    private static char toLower(char x){
        if(isNormalCharacter(x)){
            if(x < 'a'){
                return (char) (x + 32);
            }
            else {
                return x;
            }
        } else {
            throw new IllegalArgumentException("");
        }
    }
    public static int checkDigit(int[] digits){
        long sum = 0;

        for(int i=0; i<digits.length; i++){
            sum += digits[i] * (i+2);
        }

        int res = 11 - (int)(sum%11);

        switch (res){
            case 10: return 0;
            case 11: return 5;
            default: return res;
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

    private static boolean isNormalLowerCaseCharacter(char a){
        return a >= 'a' && a <= 'z';
    }
    public static void main(String[] args) {
        guessingGame(randomNumberBetweenOneAndHundred());
    }
}