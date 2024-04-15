package com.mycompany.numbergame;

import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxTries;
        String playAgain;
        
        System.out.println("Welcome to the Number Guessing Game!");
        do {
            System.out.print("Enter the maximum number of guesses (positive integer): ");
            maxTries = scanner.nextInt();

            playGame(scanner, maxTries);

            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next();
        } while (playAgain.equalsIgnoreCase("yes"));

    }

    public static void playGame(Scanner scanner, int maxTries) {
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;
        int userGuess, numAttempts = 0;

        System.out.println("Guess a number between 1 and 100: ");

        do {
            numAttempts++;
            userGuess = scanner.nextInt();

            if (userGuess == randomNumber) {
                System.out.println("Congratulations! You guessed the number in " + numAttempts + " tries.");
                break;
            } else if (userGuess < randomNumber) {
                System.out.println("Your guess is too low. Try again!");
            } else {
                System.out.println("Your guess is too high. Try again!");
            }
        } while (numAttempts < maxTries);

        if (numAttempts == maxTries) {
            System.out.println("Sorry, you ran out of guesses. The number was " + randomNumber + ".");
        }
    }
}
