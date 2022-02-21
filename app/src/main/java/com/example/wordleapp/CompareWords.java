package com.example.wordleapp;

import java.util.Arrays;

public class CompareWords {

    String[] word = {"S", "H", "A", "K", "E"};

    public Integer[] compareWords(String[] guessedWord){
        Integer[] result = new Integer[5];

        for (int i = 0; i < guessedWord.length; i++){
            if (guessedWord[i].equals(word[i])){ // <- If letter is in the word and is in the correct place

                result[i] = 1; // <- Tells main activity to display green on that view

            } else if (Arrays.stream(word).anyMatch(guessedWord[i]::equals)){ // <- If letter is in the word but is in the incorrect place

                result[i] = 0; // <- Tells main activity to display yellow on that view

            } else{ // <- If letter is not in word

                result[i] = null; // <- Tells main acidity to display black on that view
            }
        }

        return result;

    }
}
