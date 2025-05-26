package dev.m3s.programming2.homework4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hangman {
    private Random rand = new Random();
    private int randIndex;
    private List<String> words;
    private String randWord;
    private List<Character> guesses;
    private int guessNum;

    public Hangman(WordList wordlist, int guessNum) {
        words = wordlist.giveWords();
        randIndex = rand.nextInt(words.size());
        randWord = words.get(randIndex);
        this.guessNum = guessNum;

        guesses = new ArrayList<>();
    }

    public boolean guess(Character c) {
        c = Character.toLowerCase(c);
        if (randWord.contains(String.valueOf(c))) {
            if (!guesses.contains(c))
                guesses.add(c);
            return true;
        } else {
            if (guessNum > 0) {
                guessNum--;
                guesses.add(c);
            }
            return false;
        }
    }

    public List<Character> guesses() {
        return guesses;
    }

    public int guessesLeft() {
        return guessNum;
    }

    public String word() {
        return randWord;
    }

    public boolean theEnd() {
        if (guessNum == 0) {
            return true;
        } else {
        for (char ch : randWord.toCharArray()) {
            if (!guesses.contains(ch)) {
                return false; // Found a letter not guessed yet
            }
        }
        return true; // All letters guessed
    }
    }

    public boolean isWon() {
        for (char ch : randWord.toCharArray()) {
            if (!guesses.contains(ch)) {
                return false;
            }
        }
        return true;
    }
}
