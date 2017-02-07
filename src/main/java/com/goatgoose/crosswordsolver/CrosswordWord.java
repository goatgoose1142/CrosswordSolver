package com.goatgoose.crosswordsolver;

import java.util.ArrayList;
import java.util.HashMap;

public class CrosswordWord {

    private CrosswordSolver solver;

    private Direction direction;

    private ArrayList<Coord> coords;

    private HashMap<Coord, CrosswordWord> conflictingWords = new HashMap<>();

    public CrosswordWord(CrosswordSolver solver, Coord position, Direction direction) {
        this.solver = solver;
        this.direction = direction;

        populateCoords(position);
    }

    private void populateCoords(Coord initialPosition) {
        coords = new ArrayList<>();
        coords.add(initialPosition);
        if (direction == Direction.RIGHT) {
            for (int x = initialPosition.getX(); x < solver.getPuzzleWidth(); x++) {
                Coord coord = new Coord(x, initialPosition.getY());
                if (!solver.getPuzzle()[coord.getX()][coord.getY()].equals("x")) {
                    coords.add(coord);
                } else {
                    break;
                }
            }
            for (int x = initialPosition.getX(); x > 0; x--) {
                Coord coord = new Coord(x, initialPosition.getY());
                if (!solver.getPuzzle()[coord.getX()][coord.getY()].equals("x")) {
                    coords.add(coord);
                } else {
                    break;
                }
            }
        } else {
            for (int y = initialPosition.getY(); y < solver.getPuzzleHeight(); y++) {
                Coord coord = new Coord(initialPosition.getX(), y);
                if (!solver.getPuzzle()[coord.getX()][coord.getY()].equals("x")) {
                    coords.add(coord);
                } else {
                    break;
                }
            }
            for (int y = initialPosition.getY(); y > 0; y--) {
                Coord coord = new Coord(initialPosition.getX(), y);
                if (!solver.getPuzzle()[coord.getX()][coord.getY()].equals("x")) {
                    coords.add(coord);
                } else {
                    break;
                }
            }
        }
    }

    public void addConflictingWord(Coord coord, CrosswordWord word) {
        conflictingWords.put(coord, word);
    }

    public void addConflictingWord(int index, CrosswordWord word) {
        // sort coords list
    }

    public HashMap<Coord, CrosswordWord> getConflictingWords() {
        return conflictingWords;
    }

}
