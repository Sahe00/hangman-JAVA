package dev.m3s.programming2.homework4;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Initialize objects
        WordList wordList = new WordList("words.txt");
        Hangman hangman = new Hangman(wordList, 5);
        // Variables
        String word = hangman.word(); // Word to be guessed
        
        Scanner input = new Scanner(System.in);
        
        //boolean keepRunning = true;
        while (!hangman.theEnd()) {
            int guessesLeft = hangman.guessesLeft();
            List<Character> guesses = hangman.guesses();
            
            String display = "";
            for (char ch : word.toCharArray()) {
                if (guesses.contains(ch)) {
                    display += ch + " ";
                } else {
                    display += "* ";
                }
            }
            
            System.out.println("The hidden word..." + "\n" + "\n"
                + display + "\n" + "\n"
                + "Guesses left: " + guessesLeft + "\n"
                + "Guessed letters " + guesses + "\n");
            
            String guessInput = "";
            while (guessInput.length() != 1) {
                System.out.print("Guess a letter: ");
                guessInput = input.nextLine();
            }
            Character guessChar = guessInput.charAt(0);
            hangman.guess(guessChar);

            if (hangman.isWon()) {
                System.out.println("\n" + "Congratulations! You won!!!" + "\n"
                + "The hidden word was: " + "\"" + word + "\"");
            } else {
                if (hangman.theEnd()) {
                    System.out.println("\n" + "Sorry, you lost!" + "\n"
                 + "The hidden word was: " + "\"" + word + "\"");
                }
            }
        }

        
    }
}
