package com.goatgoose.crosswordsolver;

public class Main {

    public static void main(String[] args) {
        CrosswordSolver solver = new CrosswordSolver(new Puzzle(3, 3));
        solver.solve();
    }

}
