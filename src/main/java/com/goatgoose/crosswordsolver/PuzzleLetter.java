package com.goatgoose.crosswordsolver;

import java.util.ArrayList;
import java.util.List;

public class PuzzleLetter {

    Coord coord;

    List<PuzzleWord> words;

    List<Direction> startingDirections;

    char text;

    public PuzzleLetter(Coord coord) {
        this.coord = coord;
        this.words = new ArrayList<>();
        this.startingDirections = new ArrayList<>();
    }

    public void addWord(PuzzleWord word) {
        words.add(word);
    }

    public void addStartingDirection(Direction direction) {
        if (!startingDirections.contains(direction)) {
            startingDirections.add(direction);
        }
    }

    public List<Direction> getStartingDirections() {
        return startingDirections;
    }

    public boolean isStartingLetter() {
        return startingDirections.size() > 0;
    }

    public Coord getCoord() {
        return coord;
    }

    public List<PuzzleWord> getWords() {
        return words;
    }

    public char getText() {
        return text;
    }

    public void setText(char text) {
        this.text = text;
    }
}
