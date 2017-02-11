package com.goatgoose.crosswordsolver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class CrosswordSolver {

    private HashMap<Integer, ArrayList<String>> words = new HashMap<>();

    private Puzzle puzzle;

    private PuzzleWord initialWord;

    public CrosswordSolver(Puzzle puzzle) {
        this.puzzle = puzzle;

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
    }

    public void solve() {
        System.out.println("test");
    }

}