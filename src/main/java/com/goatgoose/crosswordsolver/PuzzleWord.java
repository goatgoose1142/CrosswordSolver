package com.goatgoose.crosswordsolver;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class PuzzleWord {

    private ArrayList<PuzzleLetter> letters;

    public PuzzleWord(ArrayList<PuzzleLetter> letters) {
        this.letters = letters;
    }

    public Direction getDirection() {
        // calculate direction based on 2 coords of letters
        return null;
    }

    public int length() {
        return letters.size();
    }

    public ArrayList<PuzzleLetter> getLetters() {
        return letters;
    }

}
