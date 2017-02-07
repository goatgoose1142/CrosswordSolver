package com.goatgoose.crosswordsolver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class CrosswordSolver {

    private HashMap<Integer, ArrayList<String>> words = new HashMap<>();

    private int puzzleWidth;
    private int puzzleHeight;
    private String[][] puzzle;

    private CrosswordWord initialWord;

    public CrosswordSolver(int puzzleWidth, int puzzleHeight) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/src/main/resources/enwiktionary-latest-all-titles-in-ns0"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (!words.containsKey(line.length())) {
                    words.put(line.length(), new ArrayList<>());
                }
                words.get(line.length()).add(line.toLowerCase());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.puzzleWidth = puzzleWidth;
        this.puzzleHeight = puzzleHeight;
        puzzle = new String[puzzleWidth][puzzleHeight];
        for (int x = 0; x < puzzleWidth; x++) {
            for (int y = 0; y < puzzleHeight; y++) {
                puzzle[x][y] = " ";
            }
        }
    }

    public void solve() {
        initialWord = new CrosswordWord(this, new Coord(0, 0), Direction.RIGHT);
        createCrosswordWords(initialWord);
    }

    private void createCrosswordWords(CrosswordWord word) {

    }

    public int getPuzzleWidth() {
        return puzzleWidth;
    }

    public int getPuzzleHeight() {
        return puzzleHeight;
    }

    public String[][] getPuzzle() {
        return puzzle;
    }

}