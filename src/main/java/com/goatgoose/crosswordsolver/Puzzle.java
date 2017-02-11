package com.goatgoose.crosswordsolver;

import java.util.ArrayList;

public class Puzzle {

    private int width;
    private int height;

    private PuzzleLetter[][] puzzleLetters;

    public Puzzle(int width, int height) {
        this.width = width;
        this.height = height;

        puzzleLetters = new PuzzleLetter[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                puzzleLetters[x][y] = new PuzzleLetter(new Coord(x, y));
            }
        }

        // determine starting letters
        // TODO pass in list of coords with extra starting letters for starting from middle of words
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if ((x == 0 || puzzleLetters[x - 1][y] == null) && x < width && puzzleLetters[x + 1][y] != null) {
                    puzzleLetters[x][y].addStartingDirection(Direction.RIGHT);
                }
                if ((y == 0 || puzzleLetters[x][y - 1] == null) && y < height && puzzleLetters[x][y + 1] != null) {
                    puzzleLetters[x][y].addStartingDirection(Direction.DOWN);
                }
            }
        }

        // create all words
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                PuzzleLetter letter = puzzleLetters[x][y];
                if (letter != null && letter.isStartingLetter()) {

                    // get letters to the right until a wall or the end
                    if (letter.getStartingDirections().contains(Direction.RIGHT)) {
                        ArrayList<PuzzleLetter> lettersForWord = new ArrayList<>();
                        lettersForWord.add(letter);
                        for (int i = 1; i < width; i++) {
                            PuzzleLetter letterForWord = puzzleLetters[x + i][y];
                            if (letterForWord != null) {
                                lettersForWord.add(letterForWord);
                            } else {
                                break;
                            }
                        }
                        letter.addWord(new PuzzleWord(lettersForWord));
                    }

                    // get bottom letters until a wall or the end
                    if (letter.getStartingDirections().contains(Direction.DOWN)) {
                        ArrayList<PuzzleLetter> lettersForWord = new ArrayList<>();
                        lettersForWord.add(letter);
                        for (int i = 1; i < height; i++) {
                            PuzzleLetter letterForWord = puzzleLetters[x][y + i];
                            if (letterForWord != null) {
                                lettersForWord.add(letterForWord);
                            } else {
                                break;
                            }
                        }
                        letter.addWord(new PuzzleWord(lettersForWord));
                    }
                }
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public PuzzleLetter[][] getPuzzleLetters() {
        return puzzleLetters;
    }
}
